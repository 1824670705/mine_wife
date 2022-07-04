package com.oa.application.goods.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品管理页面
 */
@Data
@TableName("oa_goods")
public class Goods implements Serializable {

    @TableId(value = "goods_id", type = IdType.ASSIGN_ID)
    private Long goodsId;

    /**
     * 供应商 Id
     */
    private Long supplierId;

    /**
     * 商品标题
     */
    private String goodsName;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品描述
     */
    @TableField("goods_desc")
    private String goodsDesc;

    /**
     * 链接
     */
    private String url;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 销售价格
     */
    private String salePrice;

    /**
     * 成本价格
     */
    private String costPrice;

    /**
     * 状态
     */
    private Integer goodsStatus;

    @ApiModelProperty(value = "备注")
    private String remake;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "0删除。1正常使用")
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;
}
