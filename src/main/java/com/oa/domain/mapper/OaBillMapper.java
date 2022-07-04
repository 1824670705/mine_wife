package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.life.entity.bo.OaBill;
import com.oa.application.life.entity.dto.OaBillListDto;
import com.oa.application.life.entity.dto.OaBillReportQueryDto;
import com.oa.application.life.entity.vo.OaBillReportResponseVo;
import com.oa.application.life.entity.vo.OaBillVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OaBillMapper extends BaseMapper<OaBill> {

    /**
     * 统计查询
     *
     * @param oaBillReportQueryVo 参数
     */
    List<OaBillReportResponseVo> queryReportBill(@Param("params") OaBillReportQueryDto oaBillReportQueryVo);

    Page<OaBillVo> getList(Page<OaBill> page, @Param("params") OaBillListDto oaBillListVo);
}
