package com.oa.application.user.controller;


import com.oa.application.user.entity.bo.OaSupplier;
import com.oa.application.user.service.IOaSupplierService;
import com.oa.application.user.vo.OaDeleteSupplierVo;
import com.oa.application.user.vo.SupplierListVo;
import com.oa.application.user.vo.SupplierSaveVo;
import com.oa.utils.result.R;
import com.oa.utils.validate.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 供应商前端控制器
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/supplier")
public class OaSupplierController {

    @Resource
    private IOaSupplierService oaSupplierService;

    /**
     * 分页查询列表
     *
     * @param supplierListVo 条件
     */
    @GetMapping("/list")
    public R getList(@Validated({Default.class}) SupplierListVo supplierListVo) {
        return R.success().data(oaSupplierService.getList(supplierListVo));
    }

    /**
     * 所有供应商数据
     */
    @GetMapping("/all/list")
    public R getAllList() {
        return R.success().data(oaSupplierService.list());
    }

    /**
     * 保存数据
     *
     * @param oaSupplier 保存数据
     */
    @PostMapping("/save")
    public R save(@RequestBody SupplierSaveVo oaSupplier) {
        return R.success().data(oaSupplierService.saveSupplier(oaSupplier));
    }

    /**
     * 更新数据
     *
     * @param oaSupplier 供应商信息
     */
    @PostMapping("/update")
    public R update(@RequestBody OaSupplier oaSupplier) {
        return R.success().data(oaSupplierService.updateById(oaSupplier));
    }

    /**
     * 删除数据
     *
     * @param oaDeleteSupplierVo 供应商信息
     */
    @PostMapping("/delete")
    public R deleteData(@RequestBody @Validated({Default.class}) OaDeleteSupplierVo oaDeleteSupplierVo) {
        return R.success().data(oaSupplierService.deleteData(oaDeleteSupplierVo));
    }
}
