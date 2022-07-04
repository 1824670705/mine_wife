package com.oa.application.menu.controller;


import com.oa.application.menu.entity.OaMenu;
import com.oa.application.menu.service.IOaMenuService;
import com.oa.application.menu.vo.DelVo;
import com.oa.application.menu.vo.MenuListVo;
import com.oa.utils.result.R;
import com.oa.utils.validate.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/menu")
public class OaMenuController {
    @Resource
    private IOaMenuService iOaMenuService;

    @GetMapping("/list")
    public R getList(@Validated MenuListVo orderListVo) {
        return R.success().data(iOaMenuService.getList(orderListVo));
    }

    @GetMapping("/details/{parentId}")
    public R getParentDetail(@PathVariable("parentId") Long parentId) {
        return R.success().data(iOaMenuService.getParentDetail(parentId));
    }

    @PostMapping("/save")
    public R saveMenu(@RequestBody OaMenu oaMenu) {
        return R.success().data(iOaMenuService.saveMenu(oaMenu));
    }

    @PostMapping("/delete")
    public R deleteRow(@RequestBody @Validated({Default.class}) DelVo delVo) {
        return R.success().data(iOaMenuService.deleteRow(delVo));
    }

    @PostMapping("/update")
    public R update(@RequestBody OaMenu oaMenu) {
        return R.success().data(iOaMenuService.updateById(oaMenu));
    }
}
