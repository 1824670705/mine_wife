package com.oa.application.menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.menu.entity.OaMenuRelation;

import java.util.List;

public interface OaMenuRelationService extends IService<OaMenuRelation> {

    Object saveByOutIds(List<Long> cusTagId, Long outId);

    /**
     * 批量删除数据
     *
     * @param relIds 关联 Id
     */
    Boolean deleteBatchByOutId(List<Long> relIds);
}
