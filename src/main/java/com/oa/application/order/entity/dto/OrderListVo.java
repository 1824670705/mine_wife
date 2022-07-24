package com.oa.application.order.entity.dto;

import com.oa.utils.dto.ParentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class OrderListVo extends ParentDto implements Serializable {

    /**
     * 搜索类型
     * 【0：客户、1：订单号】
     */
    private String searchType;

    /**
     * 检索关键字
     */
    private String searchKeyword;

    /**
     * 当前登录用户
     */
    private Long createBy;
}
