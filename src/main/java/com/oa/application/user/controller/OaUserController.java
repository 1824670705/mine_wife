package com.oa.application.user.controller;

import com.oa.application.user.entity.bo.OaUser;
import com.oa.application.user.entity.to.OaUserSaveTo;
import com.oa.application.user.service.OaUserService;
import com.oa.application.user.vo.OaUserListVo;
import com.oa.utils.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class OaUserController {

    @Resource
    private OaUserService oaUserService;

    @GetMapping("/list")
    public R getList(@Validated OaUserListVo userListVo) {
        return R.success().data(oaUserService.getList(userListVo));
    }

    @PostMapping("/save")
    public R registerUser(@RequestBody OaUserSaveTo oaUserSaveTo) {
        return R.success().data(oaUserService.registerUser(oaUserSaveTo));
    }

    @PostMapping("/delete")
    public R deleteUser(@RequestBody List<Long> userIds) {
        return R.success().data(oaUserService.deleteUser(userIds));
    }

    @PostMapping("/update")
    public R updateData(@RequestBody OaUser oaUser) {
        return R.success().data(oaUserService.updateById(oaUser));
    }
}
