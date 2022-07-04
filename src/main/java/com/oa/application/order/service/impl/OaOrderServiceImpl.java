package com.oa.application.order.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.order.entity.bo.OaOrder;
import com.oa.application.order.entity.dto.OaOrderGoodsRelationDto;
import com.oa.application.order.entity.dto.OaOrderSaveVo;
import com.oa.application.order.entity.dto.OrderListVo;
import com.oa.application.order.entity.vo.OrderDetailsVo;
import com.oa.application.order.entity.vo.OrderResponseVo;
import com.oa.application.order.service.IOaOrderService;
import com.oa.application.order.service.OaOrderGoodsRelationService;
import com.oa.domain.mapper.OaOrderMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@Service
public class OaOrderServiceImpl extends ServiceImpl<OaOrderMapper, OaOrder> implements IOaOrderService {

    @Resource
    private OaOrderGoodsRelationService oaOrderGoodsRelationService;

    @Override
    public Page<OrderResponseVo> getList(OrderListVo orderListVo) {
        Page<OaOrder> page = new Page<>(orderListVo.getPageIndex(), orderListVo.getPageSize());
        return baseMapper.getListByPage(page, orderListVo);
    }


    /**
     * 保存订单
     *
     * @param oaOrderSaveVo 订单信息
     */
    @Override
    public Boolean saveOrder(OaOrderSaveVo oaOrderSaveVo) {
        // 保存订单信息
        OaOrder oaOrder = new OaOrder();
        BeanUtils.copyProperties(oaOrderSaveVo, oaOrder);
        Optional.ofNullable(oaOrder.getShopId()).orElseGet(() -> {
            oaOrder.setShopId(0L);
            return 0L;
        });
        // 成本价格
        Double cost = oaOrderSaveVo.getShops().stream().map(OaOrderGoodsRelationDto::getCostPrice).reduce(Double::sum).orElse(0.00);
        // 利润
        Double profit = Double.parseDouble(oaOrder.getOrdPrice()) - cost;
        oaOrder.setOrdCost(String.valueOf(cost)).setOrdProfit(String.valueOf(profit));
        Optional.ofNullable(oaOrder.getExpressId()).orElseGet(() -> {
            oaOrder.setExpressId(0L);
            return 0L;
        });
        save(oaOrder);
        // 保存订单和商品的关联关系
        return oaOrderGoodsRelationService.saveBatchRelation(oaOrderSaveVo.getShops(), oaOrder.getOrderId());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean updateOrder(@NotNull OaOrderSaveVo oaOrderUpdateVo) {
        // 尝试更新关联关系
        // 更新订单数据
        OaOrder oaOrder = new OaOrder();
        Optional.ofNullable(oaOrderUpdateVo.getShops()).ifPresent(shops -> {
            // 更新数据
            oaOrderGoodsRelationService.saveBatchRelation(shops, oaOrderUpdateVo.getOrderId());
            // 成本价格
            Double cost = oaOrderUpdateVo.getShops().stream().map(OaOrderGoodsRelationDto::getCostPrice).reduce(Double::sum).orElse(0.00);
            // 利润
            Double profit = Double.parseDouble(oaOrderUpdateVo.getOrdPrice()) - cost;
            oaOrder.setOrdCost(String.valueOf(cost)).setOrdProfit(String.valueOf(profit));
        });
        BeanUtils.copyProperties(oaOrderUpdateVo, oaOrder);
        return this.updateById(oaOrder);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteOrder(List<Long> orderIds) {
        // 删除管理关系
        oaOrderGoodsRelationService.removeBatchByOrderIds(orderIds);
        // 删除订单信息
        return removeByIds(orderIds);
    }

    /**
     * 获取单个订单的详细数据
     *
     * @param orderId 订单 id
     */
    @Override
    public OrderDetailsVo getOneOrder(Long orderId) {
        return baseMapper.getOneOrder(orderId);
    }
}
