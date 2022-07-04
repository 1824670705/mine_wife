package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.oa.application.user.entity.bo.OaUser;
import com.oa.application.user.vo.OaUserListVo;
import org.apache.ibatis.annotations.Param;

public interface OaUserMapper extends BaseMapper<OaUser> {
    Page<OaUser> getList(Page<OaUser> page, @Param("userListVo") OaUserListVo userListVo);
}
