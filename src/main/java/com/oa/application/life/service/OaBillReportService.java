package com.oa.application.life.service;

import com.oa.application.life.entity.dto.OaBillReportQueryDto;

public interface OaBillReportService {

    /**
     * 报表查询
     *
     * @param oaBillReportQueryVo 查询参数
     */
    Object queryReportBill(OaBillReportQueryDto oaBillReportQueryVo);
}
