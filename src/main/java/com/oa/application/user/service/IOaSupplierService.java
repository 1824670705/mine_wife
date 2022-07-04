package com.oa.application.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.user.entity.bo.OaSupplier;
import com.oa.application.user.vo.OaDeleteSupplierVo;
import com.oa.application.user.vo.OaSupplierDto;
import com.oa.application.user.vo.SupplierListVo;
import com.oa.application.user.vo.SupplierSaveVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
public interface IOaSupplierService extends IService<OaSupplier> {

    Page<OaSupplierDto> getList(SupplierListVo supplierListVo);

    Object saveSupplier(SupplierSaveVo oaSupplier);

    /**
     * 删除数据
     *
     * @param oaDeleteSupplierVo 供应商信息
     */
    Boolean deleteData(OaDeleteSupplierVo oaDeleteSupplierVo);
}
