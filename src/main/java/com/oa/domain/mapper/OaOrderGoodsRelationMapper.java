package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oa.application.order.entity.bo.OaOrderGoodsRelation;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OaOrderGoodsRelationMapper extends BaseMapper<OaOrderGoodsRelation> {
    void removeBatchByOrderIds(@Param("orderIds") List<Long> orderIds);
}
