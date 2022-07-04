package com.oa.application.order.controller;

import com.oa.application.order.entity.dto.OaOrderGoodsRelationDto;
import com.oa.application.order.service.OaOrderGoodsRelationService;
import com.oa.utils.result.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orderGoodsRelation")
public class OaOrderGoodsRelationController {

    @Resource
    private OaOrderGoodsRelationService oaOrderGoodsRelationService;

    /**
     * 保存订单和商品的关联数据
     *
     * @param oaOrderGoodsRelationDto 参数
     */
    @PostMapping("/saveRelation")
    public R saveRelation(OaOrderGoodsRelationDto oaOrderGoodsRelationDto) {
        return R.success().data(oaOrderGoodsRelationService.saveRelation(oaOrderGoodsRelationDto));
    }

    /**
     * 获取列表
     *
     * @param orderId 订单 Id
     */
    @GetMapping("/listByOrderId")
    public R listByOrderId(Long orderId) {
        return R.success().data(oaOrderGoodsRelationService.listByOrderId(orderId));
    }
}
