package com.oa.application.order.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OaOrderReportVo implements Serializable {

    /**
     * 统计时间范围
     */
    private String dateRange;

    /**
     * 销售额
     */
    private String saleTotal;

    /**
     * 成本
     */
    private String costTotal;

    /**
     * 绿润
     */
    private String ProfitTotal;
}
