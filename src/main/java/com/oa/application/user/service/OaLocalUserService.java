package com.oa.application.user.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.user.entity.bo.OaLocalUser;

public interface OaLocalUserService extends IService<OaLocalUser>{

    List<OaLocalUser> getListByUserId(Long ownerId);
}
