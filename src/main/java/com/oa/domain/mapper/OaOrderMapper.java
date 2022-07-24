package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.order.entity.bo.OaOrder;
import com.oa.application.order.entity.dto.OaOrderReportDto;
import com.oa.application.order.entity.dto.OrderListVo;
import com.oa.application.order.entity.vo.OaOrderReportVo;
import com.oa.application.order.entity.vo.OrderDetailsVo;
import com.oa.application.order.entity.vo.OrderResponseVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
public interface OaOrderMapper extends BaseMapper<OaOrder> {

    Page<OrderResponseVo> getListByPage(Page<OaOrder> page, @Param("params") OrderListVo orderListVo);

    OrderDetailsVo getOneOrder(Long orderId);

    Page<OaOrderReportVo> query(Page<OaOrderReportVo> page, @Param("params") OaOrderReportDto oaOrderReportDto);
}
