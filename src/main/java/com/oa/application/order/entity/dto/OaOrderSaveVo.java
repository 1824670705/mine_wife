package com.oa.application.order.entity.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.oa.application.goods.vo.GoodsDto;
import com.oa.utils.validate.Update;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 订单保存参数
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OaOrderSaveVo implements Serializable {

    @NotNull(message = "主键 Id 不可以为空", groups = {Update.class})
    private Long orderId;

    @ApiModelProperty(value = "订单名称")
    private String shopName;

    @ApiModelProperty(value = "客户Id")
    private Long ordConsumerId;

    /**
     * 客户名字
     */
    private String ordConsumerName;

    @ApiModelProperty(value = "供应商Id")
    private Long ordSupplier;

    /**
     * 订单价格
     */
    private String ordPrice;

    @ApiModelProperty(value = "商品id")
    private Long shopId;

    /**
     * 商品列表
     */
    private List<OaOrderGoodsRelationDto> shops;

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
}
