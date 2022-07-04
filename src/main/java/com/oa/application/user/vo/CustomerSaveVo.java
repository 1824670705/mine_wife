package com.oa.application.user.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@Data
public class CustomerSaveVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long cusId;

    private String cusName;

    private Integer cusGender;

    private String cusMobile;

    @ApiModelProperty(value = "客户标签")
    private List<Long> cusTagId;

    private List<?> cusTag;

    /**
     * 标签名字
     */
    private List<String> cusTagName;

    @ApiModelProperty(value = "是否是黑名单")
    private Integer whetherBlack;

    @ApiModelProperty(value = "客户地址")
    private String cusLocation;

    @ApiModelProperty(value = "客户备注")
    private String remake;

    /**
     * 创建时间
     */
    private String createTime;
}
