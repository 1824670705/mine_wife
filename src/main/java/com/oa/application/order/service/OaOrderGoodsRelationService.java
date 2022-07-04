package com.oa.application.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.order.entity.bo.OaOrderGoodsRelation;
import com.oa.application.order.entity.dto.OaOrderGoodsRelationDto;

import java.util.List;

public interface OaOrderGoodsRelationService extends IService<OaOrderGoodsRelation> {

    /**
     * 保存订单和商品的关联数据
     *
     * @param oaOrderGoodsRelationDto 参数
     */
    Boolean saveRelation(OaOrderGoodsRelationDto oaOrderGoodsRelationDto);

    /**
     * 获取列表
     *
     * @param orderId 订单 Id
     */
    List<OaOrderGoodsRelation> listByOrderId(Long orderId);

    /**
     * 批量保存订单和商品的关联
     *
     * @param shops   商品信息
     * @param orderId 订单信息
     */
    Boolean saveBatchRelation(List<OaOrderGoodsRelationDto> shops, Long orderId);

    /**
     * 删除管理关系通过订单 id
     * @param orderIds 订单 Id 集合
     */
    void removeBatchByOrderIds(List<Long> orderIds);
}
