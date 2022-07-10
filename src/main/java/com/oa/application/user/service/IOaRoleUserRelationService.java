package com.oa.application.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.user.entity.bo.OaRoleUserRelation;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author L
 * @since 2022-07-03
 */
public interface IOaRoleUserRelationService extends IService<OaRoleUserRelation> {

    void bingUserRole(List<Long> oaRoleVos, Long userId);
}
