package com.oa.application.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.user.entity.bo.OaRole;
import com.oa.application.user.service.IOaRoleService;
import com.oa.domain.mapper.OaRoleMapper;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author L
 * @since 2022-07-03
 */
@Service
public class OaRoleServiceImpl extends ServiceImpl<OaRoleMapper, OaRole> implements IOaRoleService {

}
