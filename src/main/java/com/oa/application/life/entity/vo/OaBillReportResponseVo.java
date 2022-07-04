package com.oa.application.life.entity.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class OaBillReportResponseVo implements Serializable {

    /**
     * 时间范围
     */
    private String dateRange;

    /**
     * 消费类别
     */
    private String category;

    /**
     * 消费地点
     */
    private String local;

    /**
     * 金额
     */
    private String consumptionAmount;

    /**
     * 消费次数
     */
    private String consumptionVolume;
}
