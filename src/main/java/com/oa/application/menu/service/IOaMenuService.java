package com.oa.application.menu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.menu.entity.OaMenu;
import com.oa.application.menu.vo.DelVo;
import com.oa.application.menu.vo.MenuListVo;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
public interface IOaMenuService extends IService<OaMenu> {

    Page<OaMenu> getList(MenuListVo orderListVo);

    Object saveMenu(OaMenu oaMenu);

    /**
     * 删除数据
     *
     * @return 删除数据
     */
    Object deleteRow(DelVo delVo);

    /**
     * 根据 parentId 获取字典数据
     *
     * @param parentId 父节点 Id
     * @return 指定结果
     */
    List<OaMenu> getParentDetail(Long parentId);
}
