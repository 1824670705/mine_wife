package com.oa.application.user.vo;

import com.baomidou.mybatisplus.annotation.*;
import com.oa.application.menu.entity.OaMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OaCustomerDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long cusId;

    private String cusName;

    private Integer cusGender;

    private String cusMobile;

    @ApiModelProperty(value = "客户标签")
    private List<OaMenu> cusTag;

    @ApiModelProperty(value = "是否是黑名单")
    private Integer whetherBlack;

    @ApiModelProperty(value = "客户地址")
    private String cusLocation;

    @ApiModelProperty(value = "客户备注")
    private String remake;

    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
}
