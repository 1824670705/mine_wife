package com.oa.application.other.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.other.entity.dto.OaAreaListDto;
import com.oa.application.other.entity.OaArea;
import com.oa.application.other.service.IOaAreaService;
import com.oa.domain.mapper.OaAreaMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 地区服务实现类
 * </p>
 *
 * @author L
 * @since 2022-06-09
 */
@Slf4j
@Service
public class OaAreaServiceImpl extends ServiceImpl<OaAreaMapper, OaArea> implements IOaAreaService {

    /**
     * 通过父 code 获取字列表
     *
     * @param parentCode parentCode 父 code 默认是0
     */
    @Override
    public List<OaArea> getAreaListByParentCode(String parentCode) {
        return list(new QueryWrapper<OaArea>().eq("area_parent_code", parentCode));
    }

    /**
     * 获取区域的完整名字
     *
     * @param lastCode  尾部的 code
     * @param splitChar 分割符号， 默认是'/'
     * @return 返回名字
     */
    @Override
    @Cacheable(value = "area", key = "#lastCode + ':' + #splitChar")
    public String getFullAreaName(String lastCode, String splitChar) {
        if (ObjectUtils.isEmpty(lastCode)) return "";
        String areaFullName;
        OaArea oaArea = getOne(new QueryWrapper<OaArea>().eq("area_code", lastCode));
        if (ObjectUtils.isEmpty(oaArea)) return "";
        areaFullName = oaArea.getAreaName();
        if (oaArea.getAreaParentCode().equals("0")) {
            log.info("return info ----> {}", areaFullName);
            return areaFullName;
        }
        areaFullName = ObjectUtils.isEmpty(splitChar) ? "/" : splitChar + areaFullName;
        areaFullName = getFullAreaName(oaArea.getAreaParentCode(), splitChar) + areaFullName;
        return areaFullName;
    }

    @Override
    @Cacheable(value = "area:code", key = "#lastCode + ':' + #splitChar")
    public String getFullAreaCode(String lastCode, String splitChar) {
        if (ObjectUtils.isEmpty(lastCode)) return "";
        String areaFullCode;
        OaArea oaArea = getOne(new QueryWrapper<OaArea>().eq("area_code", lastCode));
        if (ObjectUtils.isEmpty(oaArea)) return "";
        areaFullCode = oaArea.getAreaCode();
        if (oaArea.getAreaParentCode().equals("0")) {
            log.info("return info ----> {}", areaFullCode);
            return areaFullCode;
        }
        areaFullCode = ObjectUtils.isEmpty(splitChar) ? "/" : splitChar + areaFullCode;
        areaFullCode = getFullAreaCode(oaArea.getAreaParentCode(), splitChar) + areaFullCode;
        return areaFullCode;
    }

    /**
     * 获取区域树结构
     */
    @Override
    @Cacheable(cacheNames = "area", key = "#root.method")
    public List<OaAreaListDto> getAreaTree() {
        List<OaArea> list = list();
        // 获取父节点数据
        List<OaAreaListDto> result = list.stream().filter(v -> v.getAreaParentCode().equals("0")).map(v -> {
            OaAreaListDto dto = new OaAreaListDto();
            BeanUtils.copyProperties(v, dto);
            return dto;
        }).collect(Collectors.toList());
        for (OaAreaListDto item : result) {
            List<OaAreaListDto> listDto = getChildCont(item, list);
            item.setChildren(listDto);
            log.info("获取成功一个 \t {}", JSON.toJSONString(item));
        }
        log.info("success");
        return result;
    }

    private List<OaAreaListDto> getChildCont(OaAreaListDto dto, List<OaArea> list) {
        List<OaAreaListDto> listDto = new ArrayList<>();
        for (OaArea childDto : list) {
            if (childDto.getAreaParentCode().equals(dto.getAreaCode())) {
                OaAreaListDto oaAreaListDto = new OaAreaListDto();
                BeanUtils.copyProperties(childDto, oaAreaListDto);
                // getChildCont(childDto, result);
                long count = list.stream().filter(item -> item.getAreaParentCode().equals(childDto.getAreaCode())).count();
                if (count > 0) {
                    List<OaAreaListDto> childCont = getChildCont(oaAreaListDto, list);
                    oaAreaListDto.setChildren(childCont);
                }
                listDto.add(oaAreaListDto);
            }
        }
        return listDto;
    }
}
