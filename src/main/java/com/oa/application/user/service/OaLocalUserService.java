package com.oa.application.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.user.entity.bo.OaLocalUser;

import java.util.List;

public interface OaLocalUserService extends IService<OaLocalUser> {

    List<OaLocalUser> getListByUserId();
}
