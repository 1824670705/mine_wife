package com.oa.application.other.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.other.entity.dto.OaAreaListDto;
import com.oa.application.other.entity.OaArea;

import java.util.List;


/**
 * <p>
 * 服务类
 * </p>
 *
 * @author L
 * @since 2022-06-09
 */
public interface IOaAreaService extends IService<OaArea> {

    /**
     * 通过 parentCode 获取对应的列表信息
     *
     * @param parentCode parentCode 父 code 默认是0
     */
    List<OaArea> getAreaListByParentCode(String parentCode);

    /**
     * 获取区域的完整名字
     *
     * @param splitChar 分割符号， 默认是'/'
     */
    String getFullAreaName(String lastCode, String splitChar);

    /**
     * 获取区域的完整 code
     *
     * @param lastCode  code
     * @param splitChar 分隔符 默认 ‘/’
     */
    String getFullAreaCode(String lastCode, String splitChar);

    /**
     * 获取区域的树结构
     *
     * @return 结构列表集合
     */
    List<OaAreaListDto> getAreaTree();
}
