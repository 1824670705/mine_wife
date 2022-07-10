package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.user.entity.bo.OaUser;
import com.oa.application.user.entity.vo.OaUserLoginResponseVo;
import com.oa.application.user.vo.OaUserListVo;
import org.apache.ibatis.annotations.Param;

public interface OaUserMapper extends BaseMapper<OaUser> {

    /**
     * 列表查询
     *
     * @param page       分页信息
     * @param userListVo 断言条件
     */
    Page<OaUser> getList(Page<OaUser> page, @Param("userListVo") OaUserListVo userListVo);

    /**
     * 用户登录逻辑查询
     *
     * @param username 用户名字或者手机号或者其他的可以登录的信息，目前的话这个参数的匹配元素是数据库中的用户名和手机号还有账户号
     * @return 登录人的基本信息和角色信息
     */
    OaUserLoginResponseVo login(String username);
}
