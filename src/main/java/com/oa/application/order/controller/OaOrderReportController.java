package com.oa.application.order.controller;

import com.oa.application.order.entity.dto.OaOrderReportDto;
import com.oa.application.order.service.OaOrderReportService;
import com.oa.utils.result.R;
import com.oa.utils.validate.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 订单报表
 */
@RestController
@RequestMapping("/report/order")
public class OaOrderReportController {

    @Resource
    private OaOrderReportService oaOrderReportService;

    /**
     * 报表查询统计
     *
     * @param oaOrderReportDto 报表信息
     */
    @GetMapping("/query")
    public R query(@Validated({Default.class}) OaOrderReportDto oaOrderReportDto) {
        return R.success().data(oaOrderReportService.query(oaOrderReportDto));
    }
}
