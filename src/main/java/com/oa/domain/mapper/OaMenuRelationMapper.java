package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oa.application.menu.entity.OaMenuRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OaMenuRelationMapper extends BaseMapper<OaMenuRelation> {
    Boolean deleteBatchByOutId(@Param("relIds") List<Long> relIds);
}
