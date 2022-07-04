package com.oa.application.order.entity.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class OaOrderGoodsRelationDto implements Serializable {

    /**
     * 单品 id
     */
    private Long goodsId;

    /**
     * 订单 id
     */
    private Long orderId;

    /**
     * 单品数量
     */
    private Integer number;

    /**
     * 成本价
     */
    private Double costPrice;
}
