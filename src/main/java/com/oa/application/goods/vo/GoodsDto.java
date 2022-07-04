package com.oa.application.goods.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class GoodsDto implements Serializable {

    private Long goodsId;

    /**
     * 供应商 Id
     */
    private Long supplierId;

    /**
     * 供应商
     */
    private String supplierName;

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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
}
