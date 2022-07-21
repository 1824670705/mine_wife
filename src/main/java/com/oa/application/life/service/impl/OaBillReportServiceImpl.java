package com.oa.application.life.service.impl;

import com.oa.application.life.entity.dto.OaBillReportQueryDto;
import com.oa.application.life.entity.vo.OaBillReportResponseVo;
import com.oa.application.life.service.OaBillReportService;
import com.oa.domain.mapper.OaBillMapper;
import com.oa.utils.other.LoginUserInfoUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@Service("oaBillReportServiceImpl")
public class OaBillReportServiceImpl implements OaBillReportService {

    @Resource
    private OaBillMapper oaBillMapper;

    /**
     * 报表查询
     *
     * @param oaBillReportQueryVo 查询参数
     */
    @Override
    public Object queryReportBill(OaBillReportQueryDto oaBillReportQueryVo) {
        oaBillReportQueryVo.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        // 统计类型
        if (oaBillReportQueryVo.getType() == 4) {
            List<Object> list = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                oaBillReportQueryVo.setType(i);
                list.add(oaBillMapper.queryReportBill(oaBillReportQueryVo));
            }
            return list;
        }
        List<OaBillReportResponseVo> reportBill = oaBillMapper.queryReportBill(oaBillReportQueryVo);
        if (oaBillReportQueryVo.getShowModel() == 2) {
            return reportBill;
        }
        return handlerResponse(reportBill);
    }

    /**
     * 处理响应数据
     *
     * @param oaBillReportResponseVos 响应结果
     */
    private Object handlerResponse(List<OaBillReportResponseVo> oaBillReportResponseVos) {
        return Map.of("xData", oaBillReportResponseVos.parallelStream().map(OaBillReportResponseVo::getDateRange).collect(Collectors.toList()), "yData", oaBillReportResponseVos.parallelStream().map(OaBillReportResponseVo::getConsumptionAmount).collect(Collectors.toList()));
    }
}
