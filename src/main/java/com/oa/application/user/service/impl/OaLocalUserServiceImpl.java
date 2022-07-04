package com.oa.application.user.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.user.entity.bo.OaLocalUser;
import com.oa.application.user.service.OaLocalUserService;
import com.oa.domain.mapper.OaLocalUserMapper;

@Service("oaLocalUserService")
public class OaLocalUserServiceImpl extends ServiceImpl<OaLocalUserMapper, OaLocalUser> implements OaLocalUserService  {

    @Override
    public List<OaLocalUser> getListByUserId(Long ownerId) {

        return null;
    }

}
