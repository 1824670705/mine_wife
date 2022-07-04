package com.oa.application.menu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.menu.entity.OaMenuRelation;
import com.oa.application.menu.service.OaMenuRelationService;
import com.oa.domain.mapper.OaMenuRelationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OaMenuRelationImpl extends ServiceImpl<OaMenuRelationMapper, OaMenuRelation> implements OaMenuRelationService {

    /**
     * 通过标签保存关联关系
     *
     * @param cusTagIds 标签 Id
     * @param outId     外部 Id
     */
    @Override
    public Object saveByOutIds(List<Long> cusTagIds, Long outId) {
        List<OaMenuRelation> collect = cusTagIds.stream().map(menuId -> {
            OaMenuRelation relation = new OaMenuRelation();
            relation.setOutId(outId);
            relation.setMenuId(menuId);
            return relation;
        }).collect(Collectors.toList());
        return saveBatch(collect);
    }

    /**
     * 批量删除关联关系
     *
     * @param relIds 关联 Id
     */
    @Override
    public Boolean deleteBatchByOutId(List<Long> relIds) {
        return baseMapper.deleteBatchByOutId(relIds);
    }
}
