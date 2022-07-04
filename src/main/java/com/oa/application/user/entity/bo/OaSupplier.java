package com.oa.application.user.entity.bo;

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
@TableName("oa_supplier")
@ApiModel(value = "OaSupplier对象", description = "")
public class OaSupplier implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "供应商主键")
    @TableId(value = "supplier_id", type = IdType.ASSIGN_ID)
    private Long supplierId;

    @ApiModelProperty(value = "供应商名字")
    private String supplierName;

    @ApiModelProperty(value = "手机号")
    private String supplierMobile;

    @ApiModelProperty(value = "供应商备注")
    private String supplierRemake;

    @ApiModelProperty(value = "供应商地址")
    private String supplierLocale;

    @ApiModelProperty(value = "供应商标签")
    private Long supplierTagId;

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

    @ApiModelProperty(value = "供应商开发人")
    private Long createBy;


}
