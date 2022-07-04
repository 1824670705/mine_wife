package com.oa.application.order.entity.vo;

import com.oa.application.goods.vo.GoodsSaveVo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单的详细数据
 */
@Data
public class OrderDetailsVo implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long orderId;

    @ApiModelProperty(value = "订单名称")
    private String shopName;

    @ApiModelProperty(value = "客户Id")
    private Long ordConsumerId;

    @ApiModelProperty(value = "客户名字")
    private String ordConsumerName;

    @ApiModelProperty(value = "供应商Id")
    private Long ordSupplier;

    @ApiModelProperty(value = "订单价格")
    private String ordPrice;

    @ApiModelProperty(value = "商品id")
    private Long shopId;

    @ApiModelProperty(value = "快递单号")
    private String ordExpressNo;

    @ApiModelProperty(value = "快递公司id")
    private Long expressId;

    @ApiModelProperty(value = "订单状态")
    private Integer ordStatus;

    @ApiModelProperty(value = "备注")
    private String ordRemake;

    @ApiModelProperty(value = "订单地址Id")
    private Integer localeId;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    private List<GoodsSaveVo> shops;
}
