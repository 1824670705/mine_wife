package com.oa.application.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.user.entity.bo.OaRole;
import com.oa.application.user.entity.vo.OaRoleVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author L
 * @since 2022-07-03
 */
public interface IOaRoleService extends IService<OaRole> {

    /**
     * 获取角色列表
     */
    List<OaRoleVo> getRoleList();
}
