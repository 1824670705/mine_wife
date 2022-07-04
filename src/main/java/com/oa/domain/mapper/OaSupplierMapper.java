package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.user.entity.bo.OaSupplier;
import com.oa.application.user.vo.OaSupplierDto;
import com.oa.application.user.vo.SupplierListVo;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
public interface OaSupplierMapper extends BaseMapper<OaSupplier> {

    Page<OaSupplierDto> getList(Page<OaSupplierDto> page, @Param("supplierListVo") SupplierListVo supplierListVo);
}
