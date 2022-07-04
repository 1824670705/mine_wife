package com.oa.application.order.entity.bo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StringSerializer;
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
@TableName("oa_express")
@ApiModel(value = "OaExpress对象", description = "OaExpress对象")
public class OaExpress implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "express_id", type = IdType.ASSIGN_ID)
    @JsonSerialize(using = StringSerializer.class)
    private Long expressId;

    @ApiModelProperty(value = "快递公司名字")
    private String expressName;

    @ApiModelProperty(value = "备注")
    private String remake;

    @ApiModelProperty(value = "快递公司电话")
    private String expressMobile;

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
