package com.oa.application.order.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.order.entity.dto.OaOrderReportDto;
import com.oa.application.order.entity.vo.OaOrderReportVo;

public interface OaOrderReportService {

    /**
     * 报表列表查询
     *
     * @param oaOrderReportDto 条件
     */
    Page<OaOrderReportVo> query(OaOrderReportDto oaOrderReportDto);
}
