package com.oa.application.menu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.menu.entity.OaMenu;
import com.oa.application.menu.service.IOaMenuService;
import com.oa.application.menu.vo.DelVo;
import com.oa.application.menu.vo.MenuListVo;
import com.oa.domain.mapper.OaMenuMapper;
import com.oa.utils.other.LoginUserInfoUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@Service
public class OaMenuServiceImpl extends ServiceImpl<OaMenuMapper, OaMenu> implements IOaMenuService {

    @Override
    public Page<OaMenu> getList(MenuListVo orderListVo) {
        Page<OaMenu> page = new Page<>(orderListVo.getPageIndex(), orderListVo.getPageSize());
        QueryWrapper<OaMenu> wrapper = new QueryWrapper<>();
        Optional.ofNullable(orderListVo.getParentMenuId()).ifPresent(parentMenuId ->
                wrapper.eq("parent_menu_id", parentMenuId)
        );
        wrapper.eq("create_by", LoginUserInfoUtils.getLoginUserId());
        return baseMapper.selectPage(page, wrapper);
    }

    /**
     * 保存数据
     *
     * @param oaMenu 要保存的数据
     */
    @Override
    public Object saveMenu(OaMenu oaMenu) {
        oaMenu.setCreateBy(LoginUserInfoUtils.getLoginUserId());
        return this.save(oaMenu);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Object deleteRow(DelVo delVo) {
        if (delVo.getWhetherParent() != null && delVo.getWhetherParent() == 1) {
            QueryWrapper<OaMenu> wrapper = new QueryWrapper<OaMenu>().in("menu_id", delVo.getDelIds());
            List<OaMenu> oaMenus = baseMapper.selectList(wrapper);
            // 删除主数据
            if (!ObjectUtils.isEmpty(delVo.getDelIds())) {
                removeByIds(delVo.getDelIds());
            }
            // 删除子数据
            baseMapper.delByParentIds(oaMenus.stream().map(OaMenu::getMenuId).collect(Collectors.toList()));
        } else {
            if (!ObjectUtils.isEmpty(delVo.getDelIds())) {
                removeByIds(delVo.getDelIds());
            }
        }
        return null;
    }

    @Override
    public List<OaMenu> getParentDetail(Long parentId) {
        return list(new QueryWrapper<OaMenu>().eq("parent_menu_id", parentId));
    }
}
