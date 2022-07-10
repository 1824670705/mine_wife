package com.oa.application.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.user.entity.bo.OaRoleUserRelation;
import com.oa.application.user.service.IOaRoleUserRelationService;
import com.oa.domain.mapper.OaRoleUserRelationMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author L
 * @since 2022-07-03
 */
@Service("oaRoleUserRelationService")
public class OaRoleUserRelationServiceImpl extends ServiceImpl<OaRoleUserRelationMapper, OaRoleUserRelation> implements IOaRoleUserRelationService {

    /**
     * 绑定用户和角色的信息
     *
     * @param oaRoleVos 角色信息
     * @param userId    用户 id
     */
    @Override
    public void bingUserRole(List<Long> oaRoleVos, Long userId) {
        // 保存
        List<OaRoleUserRelation> collect = oaRoleVos.parallelStream().map(v -> {
            OaRoleUserRelation relation = new OaRoleUserRelation();
            relation.setRoleUserId(v).setUserId(userId);
            return relation;
        }).collect(Collectors.toList());
        saveBatch(collect);
    }
}
