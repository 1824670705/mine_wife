package com.oa.application.user.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.menu.service.OaMenuRelationService;
import com.oa.application.other.service.IOaAreaService;
import com.oa.application.user.entity.bo.OaCustomer;
import com.oa.application.user.service.IOaCustomerService;
import com.oa.application.user.vo.CustomerListVo;
import com.oa.application.user.vo.CustomerSaveVo;
import com.oa.application.user.vo.OaCustomerDto;
import com.oa.domain.mapper.OaCustomerMapper;
import com.oa.utils.other.LoginUserInfoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 客户服务实现类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@Service
public class OaCustomerServiceImpl extends ServiceImpl<OaCustomerMapper, OaCustomer> implements IOaCustomerService {

    @Resource
    private OaMenuRelationService oaMenuRelationService;
    @Resource
    private IOaAreaService iOaAreaService;

    @Override
    public Page<OaCustomerDto> getList(CustomerListVo customerListVo) {
        Page<OaCustomerDto> page = new Page<>(customerListVo.getPageIndex(), customerListVo.getPageSize());
        customerListVo.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        Page<OaCustomerDto> listPage = baseMapper.getList(page, customerListVo);
        listPage.setRecords(listPage.getRecords().stream().peek(v -> v.setCusLocation(iOaAreaService.getFullAreaName(v.getCusLocation(), "-"))).collect(Collectors.toList()));
        return listPage;
    }

    @Override
    public Object saveConsumer(CustomerSaveVo customerSaveVo) {
        OaCustomer customer = new OaCustomer();
        BeanUtils.copyProperties(customerSaveVo, customer);
        // 性别默认值
        Optional.ofNullable(customer.getCusGender()).orElseGet(() -> {
            customer.setCusGender(1);
            return null;
        });
        // 是否是黑名单
        Optional.ofNullable(customer.getCusGender()).orElseGet(() -> {
            customer.setWhetherBlack(0);
            return null;
        });
        customer.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        save(customer.setCusTagId(""));
        // 保存标签关系
        return oaMenuRelationService.saveByOutIds(customerSaveVo.getCusTagId(), customer.getCusId());
    }

    @Override
    public Boolean deleteData(List<Long> customerIds) {
        oaMenuRelationService.deleteBatchByOutId(customerIds);
        return removeByIds(customerIds);
    }
}
