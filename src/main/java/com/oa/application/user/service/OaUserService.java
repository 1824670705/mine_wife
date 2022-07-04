package com.oa.application.user.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.user.entity.bo.OaUser;
import com.oa.application.user.vo.OaUserLoginVo;
import com.oa.application.user.vo.OaUserListVo;
import com.oa.application.user.entity.vo.OaUserLoginResponseVo;

import java.util.List;

public interface OaUserService extends IService<OaUser> {

    /**
     * 分页获取用户列表
     *
     * @param userListVo 参数信息
     */
    Page<OaUser> getList(OaUserListVo userListVo);

    /**
     * 用户登陆
     *
     * @param oaUSerLoginVo 登陆校验信息
     * @return token等信息
     */
    OaUserLoginResponseVo login(OaUserLoginVo oaUSerLoginVo);

    /**
     * 添加新用户
     *
     * @param oaUser 用户信息
     */
    Object registerUser(OaUser oaUser);

    /**
     * 逻辑删除用户
     *
     * @param userIds 用户 Ids
     */
    Boolean deleteUser(List<Long> userIds);
}
