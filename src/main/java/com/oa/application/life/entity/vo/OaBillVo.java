package com.oa.application.life.entity.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class OaBillVo implements Serializable {
    /**
     * 账单 id
     */
    private Long billId;

    /**
     * 商品名字
     */
    private String billGoodsName;

    /**
     * 账单描述
     */
    private String billDesc;

    /**
     * 实际支付金额
     */
    private String realPrice;

    /**
     * 店铺
     */
    private String billShop;

    /**
     * 地址完整 Id
     */
    private String[] localFullId;

    /**
     * 地址 Id
     */
    private String localLastId;

    /**
     * 地址的全程
     */
    private String localFullName;

    /**
     * 支付方式 id
     */
    private String payTypeId;

    /**
     * 支付方式 Id
     */
    private String payTypeName;

    /**
     * 账单类型名字
     */
    private String billTypeName;

    /**
     * 账单类型 Id
     */
    private String billTypeId;

    /**
     * 创建者
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

}
