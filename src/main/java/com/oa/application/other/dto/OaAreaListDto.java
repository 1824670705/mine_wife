package com.oa.application.other.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class OaAreaListDto implements Serializable {

    /**
     * code
     */
    private String areaCode;

    /**
     * label 名字
     */
    private String areaName;

    /**
     * 父类 Id
     */
    private String areaParentCode;

    /**
     * 子节点
     */
    private List<OaAreaListDto> children;
}
