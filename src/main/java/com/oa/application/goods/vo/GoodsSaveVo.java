package com.oa.application.goods.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class GoodsSaveVo implements Serializable {

    private Long goodsId;

    /**
     * 供应商 Id
     */
    private Long supplierId;

    /**
     * 商品标题
     */
    private String GoodsName;

    /**
     * 商品编号
     */
    private String goodsCode;

    /**
     * 商品描述
     */
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

    /**
     * 备注
     */
    private String remake;
}
