package com.oa.application.user.controller;


import com.oa.application.user.entity.bo.OaCustomer;
import com.oa.application.user.service.IOaCustomerService;
import com.oa.application.user.vo.CustomerListVo;
import com.oa.application.user.vo.CustomerSaveVo;
import com.oa.utils.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 客户前端控制器
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/customer")
public class OaCustomerController {

    @Resource
    private IOaCustomerService oaCustomerService;

    @GetMapping("/list")
    public R getList(@Validated CustomerListVo customerListVo) {
        return R.success().data(oaCustomerService.getList(customerListVo));
    }

    @GetMapping("/all/list")
    public R getAllList() {
        return R.success().data(oaCustomerService.list());
    }

    @PostMapping("/save")
    public R save(@RequestBody CustomerSaveVo customerSaveVo) {
        return R.success().data(oaCustomerService.saveConsumer(customerSaveVo));
    }

    @PostMapping("/update")
    public R update(@RequestBody OaCustomer oaCustomer) {
        return R.success().data(oaCustomerService.updateById(oaCustomer));
    }

    @PostMapping("/delete")
    public R deleteData(@RequestBody List<Long> customerIds) {
        return R.success().data(oaCustomerService.deleteData(customerIds));
    }
}
