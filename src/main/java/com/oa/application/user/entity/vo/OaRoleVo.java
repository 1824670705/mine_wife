package com.oa.application.user.entity.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * 角色 Vo
 */
@Data
public class OaRoleVo implements Serializable {
    /**
     * 角色 Id
     */
    private Long roleId;

    /**
     * 角色名字
     */
    private String roleName;
}
