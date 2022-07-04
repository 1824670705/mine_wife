package com.oa.application.goods.controller;

import com.oa.application.goods.service.GoodsService;
import com.oa.application.goods.vo.GoodsDeleteVo;
import com.oa.application.goods.vo.GoodsListDto;
import com.oa.application.goods.vo.GoodsSaveVo;
import com.oa.utils.result.R;
import com.oa.utils.validate.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 单品管理
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Resource
    private GoodsService goodsService;

    @GetMapping("/list")
    public R getList(GoodsListDto goodsListVo) {
        return R.success().data(goodsService.getList(goodsListVo));
    }

    @PostMapping("/save")
    public R saveData(@RequestBody GoodsSaveVo goodsSaveVo) {
        return R.success().data(goodsService.saveData(goodsSaveVo));
    }

    /**
     * 删除单品
     *
     * @param goodsDeleteVo 单品删除
     */
    @PostMapping("/delete")
    public R deleteData(@Validated({Default.class}) @RequestBody GoodsDeleteVo goodsDeleteVo) {
        return R.success().data(goodsService.deleteData(goodsDeleteVo));
    }
}
