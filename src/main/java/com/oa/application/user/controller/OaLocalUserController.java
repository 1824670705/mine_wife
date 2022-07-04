package com.oa.application.user.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oa.application.user.service.OaLocalUserService;
import com.oa.utils.result.R;

/**
 * 用户地址列表
 */
@RestController
@RequestMapping("/userLocal")
public class OaLocalUserController {

    @Resource
    private OaLocalUserService oaLocalUserService;

    @GetMapping("/getListByUserId")
    public R getListByUserId(Long ownerId) {
        return R.success().data(oaLocalUserService.getListByUserId(ownerId));
    }

    @PostMapping("/save")
    public R saveLocalByUserId() {
        return R.success();
    }
}
