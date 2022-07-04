package com.oa.application.order.entity.dto;

import com.oa.utils.dto.ParentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
public class OaOrderReportDto extends ParentDto {

    /**
     * 统计维度
     * 【0：客户，1：单品，2：时间】
     */
    private Integer statisticsGranularity;

    /**
     * 统计时间范围
     */
    private Date[] dateRange;
}
