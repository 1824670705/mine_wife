package com.oa.application.order.entity.bo;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("oa_order")
@ApiModel(value = "订单对象", description = "")
public class OaOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "order_id", type = IdType.ASSIGN_ID)
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

    /**
     * 订单成本价格
     */
    private String ordCost;

    /**
     * 订单利润
     */
    private String ordProfit;

    @ApiModelProperty(value = "备注")
    private String ordRemake;

    @ApiModelProperty(value = "订单地址Id")
    private Integer localeId;

    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

    @ApiModelProperty(value = "逻辑删除[0删除1没有删除]")
    @TableLogic
    @TableField(fill = FieldFill.INSERT)
    private Integer logicDel;
}
