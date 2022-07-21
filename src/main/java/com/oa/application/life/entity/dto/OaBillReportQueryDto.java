package com.oa.application.life.entity.dto;

import com.oa.utils.validate.Default;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

@Data
public class OaBillReportQueryDto implements Serializable {

    /**
     * 时间范围
     */
    @NotNull(message = "时间范围不可以为空", groups = {Default.class})
    private Date[] dateRange;

    /**
     * 显示模式
     * 【0：图饼、1：直方图、2：表格】
     */
    @NotNull(message = "显示模式不可以为空", groups = {Default.class})
    private Integer showModel;

    /**
     * 类型
     * 【0：时间粒度、1：支付方式、2：消费类型、3：支付地点，4：全选】
     */
    @Max(message = "类型最大值为4【0：时间粒度、1：支付方式、2：消费类型、3：支付地点，4：全选】", value = 4, groups = {Default.class})
    @Min(message = "类型最小值为0【0：时间粒度、1：支付方式、2：消费类型、3：支付地点，4：全选】", value = 0, groups = {Default.class})
    @NotNull(message = "类型不可以为空", groups = {Default.class})
    private Integer type;

    /**
     * 时间粒度
     * 【0：日，1：月，2：年，3：累计时间】
     */
    @Max(message = "类型最大值为3【0：日，1：月，2：年，3：累计时间】", value = 3, groups = {Default.class})
    @Min(message = "类型最小值为0【0：日，1：月，2：年，3：累计时间】", value = 0, groups = {Default.class})
    private Integer dateGranularity;

    /**
     * 当前登录用户
     */
    private Long createBy;
}
