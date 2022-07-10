package com.oa.application.user.controller;

import com.oa.application.user.service.IOaRoleService;
import com.oa.utils.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/role")
public class OaRoleController {

    @Resource
    private IOaRoleService roleService;

    @GetMapping("/list")
    public R getRoleList() {
        return R.success().data(roleService.getRoleList());
    }
}
