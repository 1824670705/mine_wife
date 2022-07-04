package com.oa.application.order.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.order.entity.dto.OaOrderReportDto;
import com.oa.application.order.entity.vo.OaOrderReportVo;
import com.oa.application.order.service.OaOrderReportService;
import com.oa.domain.mapper.OaOrderMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("oaOrderReportService")
public class OaOrderReportServiceImpl implements OaOrderReportService {

    @Resource
    private OaOrderMapper oaOrderMapper;

    @Override
    public Page<OaOrderReportVo> query(OaOrderReportDto oaOrderReportDto) {
        return oaOrderMapper.query(new Page<>(oaOrderReportDto.getPageIndex(), oaOrderReportDto.getPageSize()), oaOrderReportDto);
    }
}
