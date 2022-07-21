package com.oa.application.menu.vo;

import com.oa.utils.dto.ParentDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class MenuListVo extends ParentDto implements Serializable {

    /**
     * 父类 Id
     * <p>
     * 默认是0，没有默认值就是父的id
     * </p>
     */
    private Long parentMenuId;

    /**
     * 当亲登录用户
     */
    private Long createBy;
}
