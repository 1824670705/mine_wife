package com.oa.application.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.order.entity.bo.OaOrder;
import com.oa.application.order.entity.dto.OaOrderSaveVo;
import com.oa.application.order.entity.dto.OrderListVo;
import com.oa.application.order.entity.vo.OrderDetailsVo;
import com.oa.application.order.entity.vo.OrderResponseVo;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
public interface IOaOrderService extends IService<OaOrder> {

    Page<OrderResponseVo> getList(OrderListVo orderListVo);

    /**
     * 保存订单
     *
     * @param oaOrderSaveVo 订单信息
     */
    Boolean saveOrder(OaOrderSaveVo oaOrderSaveVo);

    /**
     * 更新数据
     *
     * @param oaOrderUpdateVo 更新的数据
     */
    Boolean updateOrder(OaOrderSaveVo oaOrderUpdateVo);

    /**
     * 删除订单信息
     *
     * @param orderIds 订单 Id 集合
     */
    Boolean deleteOrder(List<Long> orderIds);

    OrderDetailsVo getOneOrder(Long orderId);
}
