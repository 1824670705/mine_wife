package com.oa.application.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.user.entity.bo.OaLocalUser;
import com.oa.application.user.service.OaLocalUserService;
import com.oa.domain.mapper.OaLocalUserMapper;
import com.oa.utils.other.LoginUserInfoUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("oaLocalUserService")
public class OaLocalUserServiceImpl extends ServiceImpl<OaLocalUserMapper, OaLocalUser> implements OaLocalUserService {

    @Override
    public List<OaLocalUser> getListByUserId() {
        Long loginUserId = LoginUserInfoUtils.getLoginUserId();
        QueryWrapper<OaLocalUser> wrapper = new QueryWrapper<>();
        wrapper.eq("create_by", loginUserId);
        return list(wrapper);
    }

}
