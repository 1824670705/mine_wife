package com.oa.application.other.controller;


import com.oa.application.other.service.IOaAreaService;
import com.oa.utils.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author L
 * @since 2022-06-09
 */
@RestController
@RequestMapping("/area")
public class OaAreaController {

    @Resource
    private IOaAreaService oaAreaService;

    /**
     * 通过 parentCode 获取对应的列表信息
     *
     * @param parentCode parentCode
     */
    @GetMapping("/getAreaListByCode")
    public R getAreaListByParentCode(String parentCode) {
        return R.success().data(oaAreaService.getAreaListByParentCode(parentCode));
    }

    @GetMapping("/getAreaTree")
    public R getAreaTree() {
        return R.success().data(oaAreaService.getAreaTree());
    }
}
