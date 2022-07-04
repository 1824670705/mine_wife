package com.oa.domain.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oa.application.menu.entity.OaMenu;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
public interface OaMenuMapper extends BaseMapper<OaMenu> {

    void delByParentIds(List<Long> collect);
}
