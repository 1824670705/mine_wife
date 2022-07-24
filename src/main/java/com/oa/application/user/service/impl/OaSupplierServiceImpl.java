package com.oa.application.user.service.impl;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.menu.service.OaMenuRelationService;
import com.oa.application.other.service.IOaAreaService;
import com.oa.application.user.entity.bo.OaSupplier;
import com.oa.application.user.service.IOaSupplierService;
import com.oa.application.user.vo.OaDeleteSupplierVo;
import com.oa.application.user.vo.OaSupplierDto;
import com.oa.application.user.vo.SupplierListVo;
import com.oa.application.user.vo.SupplierSaveVo;
import com.oa.domain.mapper.OaSupplierMapper;
import com.oa.utils.other.LoginUserInfoUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * <p>
 * 供应商服务实现类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@Service("oaSupplierService")
public class OaSupplierServiceImpl extends ServiceImpl<OaSupplierMapper, OaSupplier> implements IOaSupplierService {

    @Resource
    private OaMenuRelationService oaMenuRelationService;
    @Resource
    private IOaAreaService iOaAreaService;

    @Override
    public Page<OaSupplierDto> getList(SupplierListVo supplierListVo) {
        Page<OaSupplierDto> page = new Page<>(supplierListVo.getPageIndex(), supplierListVo.getPageSize());
        supplierListVo.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        Page<OaSupplierDto> listPage = baseMapper.getList(page, supplierListVo);
        listPage.setRecords(listPage.getRecords().stream().peek(v -> v.setSupplierLocale(iOaAreaService.getFullAreaName(v.getSupplierLocale(), "-"))).collect(Collectors.toList()));
        return listPage;
    }

    /**
     * 保存供应商
     *
     * @param oaSupplierVo 供应商信息
     */
    @Override
    public Object saveSupplier(SupplierSaveVo oaSupplierVo) {
        OaSupplier oaSupplier = new OaSupplier();
        oaSupplier.setCreateBy(1L);
        BeanUtils.copyProperties(oaSupplierVo, oaSupplier);
        save(oaSupplier.setCreateBy(LoginUserInfoUtils.getLoginUserId()).setSupplierTagId(null));
        return oaMenuRelationService.saveByOutIds(oaSupplierVo.getSupplierTagId(), oaSupplier.getSupplierId());
    }

    /**
     * 删除数据
     *
     * @param oaDeleteSupplierVo 供应商信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteData(OaDeleteSupplierVo oaDeleteSupplierVo) {
        OaSupplier supplier = getById(oaDeleteSupplierVo.getSupplierId());
        if (ObjectUtils.isEmpty(supplier)) throw new RuntimeException("供应商信息不存在");
        // 删除标签
        Boolean batch = oaMenuRelationService.deleteBatchByOutId(Collections.singletonList(oaDeleteSupplierVo.getSupplierId()));
        // 删除供应商
        Assert.isTrue(!batch, "删除标签失败");
        return removeById(oaDeleteSupplierVo.getSupplierId());
    }
}
