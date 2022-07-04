package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.user.entity.bo.OaCustomer;
import com.oa.application.user.vo.CustomerListVo;
import com.oa.application.user.vo.OaCustomerDto;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
public interface OaCustomerMapper extends BaseMapper<OaCustomer> {

    Page<OaCustomerDto> getList(Page<OaCustomerDto> page, @Param("customerListVo") CustomerListVo customerListVo);
}
