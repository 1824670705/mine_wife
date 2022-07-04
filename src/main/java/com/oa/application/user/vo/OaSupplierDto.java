package com.oa.application.user.vo;

import com.oa.application.menu.entity.OaMenu;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Data
public class OaSupplierDto implements Serializable {

    @ApiModelProperty(value = "供应商主键")
    private Long supplierId;

    @ApiModelProperty(value = "供应商名字")
    private String supplierName;

    @ApiModelProperty(value = "手机号")
    private String supplierMobile;

    @ApiModelProperty(value = "供应商备注")
    private String supplierRemake;

    @ApiModelProperty(value = "供应商地址")
    private String supplierLocale;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "供应商开发人")
    private Long createBy;

    /**
     * 供应商标签
     */
    private List<OaMenu> supplierTags;
}
