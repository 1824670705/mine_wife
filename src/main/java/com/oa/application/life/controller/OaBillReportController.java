package com.oa.application.life.controller;

import com.oa.application.life.service.OaBillReportService;
import com.oa.application.life.entity.dto.OaBillReportQueryDto;
import com.oa.utils.result.R;
import com.oa.utils.validate.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 账单报表系统
 */
@RestController
@RequestMapping("/report/bill")
public class OaBillReportController {

    @Resource
    private OaBillReportService oaBillReportService;

    /**
     * 查询账单报表
     *
     * @param oaBillReportQueryVo 查询条件
     */
    @GetMapping("/query")
    public R queryReportBill(@Validated({Default.class}) OaBillReportQueryDto oaBillReportQueryVo) {
        return R.success().data(oaBillReportService.queryReportBill(oaBillReportQueryVo));
    }
}
