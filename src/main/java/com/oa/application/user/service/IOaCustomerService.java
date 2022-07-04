package com.oa.application.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.user.entity.bo.OaCustomer;
import com.oa.application.user.vo.CustomerListVo;
import com.oa.application.user.vo.CustomerSaveVo;
import com.oa.application.user.vo.OaCustomerDto;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
public interface IOaCustomerService extends IService<OaCustomer> {

    Page<OaCustomerDto> getList(CustomerListVo customerListVo);

    Object saveConsumer(CustomerSaveVo customerSaveVo);

    /**
     * 删除客户
     *
     * @param customerIds 客户 id
     */
    Boolean deleteData(List<Long> customerIds);
}
