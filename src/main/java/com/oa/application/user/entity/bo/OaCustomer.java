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
@TableName("oa_customer")
@ApiModel(value = "客户对象", description = "")
public class OaCustomer implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "cus_id", type = IdType.ASSIGN_ID)
    private Long cusId;

    private String cusName;

    private Integer cusGender;

    private String cusMobile;

    @ApiModelProperty(value = "客户标签")
    private String cusTagId;

    /**
     * 是否是黑名单
     * 0：否，1：是
     */
    private Integer whetherBlack;

    @ApiModelProperty(value = "客户地址")
    private String cusLocation;

    @ApiModelProperty(value = "客户备注")
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
