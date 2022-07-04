package com.oa.application.life.entity.bo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Oa 账单
 */
@Data
@TableName("oa_bill")
public class OaBill implements Serializable {

    /**
     * 账单 id
     */
    @TableId(value = "bill_id", type = IdType.ASSIGN_ID)
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
     * 地址Id
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
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    /**
     * 逻辑删除[0删除1没有删除]
     */
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;
}
