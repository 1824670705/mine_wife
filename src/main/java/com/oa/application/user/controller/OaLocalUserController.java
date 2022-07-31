package com.oa.application.user.controller;

import com.oa.application.user.entity.bo.OaLocalUser;
import com.oa.application.user.service.OaLocalUserService;
import com.oa.utils.result.R;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户地址列表
 */
@RestController
@RequestMapping("/userLocal")
public class OaLocalUserController {

    @Resource
    private OaLocalUserService oaLocalUserService;

    @GetMapping("/list")
    public R getListByUserId() {
        return R.success().data(oaLocalUserService.getListByUserId());
    }

    @PostMapping("/save")
    public R saveLocalByUserId(@RequestBody OaLocalUser oaLocalUser) {
        return R.success().data(oaLocalUserService.save(oaLocalUser));
    }
}
