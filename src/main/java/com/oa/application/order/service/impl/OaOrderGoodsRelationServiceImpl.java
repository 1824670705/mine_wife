package com.oa.application.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.order.entity.bo.OaOrderGoodsRelation;
import com.oa.application.order.entity.dto.OaOrderGoodsRelationDto;
import com.oa.application.order.service.OaOrderGoodsRelationService;
import com.oa.domain.mapper.OaOrderGoodsRelationMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.validation.constraints.NotNull;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service("oaOrderGoodsRelationService")
public class OaOrderGoodsRelationServiceImpl extends ServiceImpl<OaOrderGoodsRelationMapper, OaOrderGoodsRelation> implements OaOrderGoodsRelationService {

    @Override
    public Boolean saveRelation(OaOrderGoodsRelationDto oaOrderGoodsRelationDto) {

        return null;
    }

    @Override
    public List<OaOrderGoodsRelation> listByOrderId(Long orderId) {

        return null;
    }

    @Override
    public Boolean saveBatchRelation(@NotNull List<OaOrderGoodsRelationDto> shops, @NotNull Long orderId) {
        List<OaOrderGoodsRelation> collect = shops.stream().map(goods -> {
            OaOrderGoodsRelation relation = new OaOrderGoodsRelation();
            relation.setGoodsId(goods.getGoodsId()).setOrderId(orderId);
            return relation;
        }).collect(Collectors.toList());
        if (!ObjectUtils.isEmpty(orderId))
            this.removeBatchByOrderIds(Collections.singletonList(orderId));
        return this.saveBatch(collect);
    }

    /**
     * 批量删除订单关联信息
     *
     * @param orderIds 订单 Id 集合
     */
    @Override
    public void removeBatchByOrderIds(List<Long> orderIds) {
        baseMapper.removeBatchByOrderIds(orderIds);
    }
}
