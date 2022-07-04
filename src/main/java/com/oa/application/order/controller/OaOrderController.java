package com.oa.application.order.controller;


import com.oa.application.order.entity.dto.OaOrderSaveVo;
import com.oa.application.order.entity.dto.OrderListVo;
import com.oa.application.order.service.IOaOrderService;
import com.oa.utils.result.R;
import com.oa.utils.validate.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author L
 * @since 2022-05-22
 */
@RestController
@RequestMapping("/order")
public class OaOrderController {
    @Resource
    private IOaOrderService oaOrderService;

    @GetMapping("/list")
    public R getList(@Validated({Default.class}) OrderListVo orderListVo) {
        return R.success().data(oaOrderService.getList(orderListVo));
    }

    @GetMapping("/one/{orderId}")
    public R getOneOrder(@PathVariable("orderId") Long orderId) {
        return R.success().data(oaOrderService.getOneOrder(orderId));
    }

    @PostMapping("/save")
    public R saveOrder(@RequestBody OaOrderSaveVo oaOrderSaveVo) {
        return R.success().data(oaOrderService.saveOrder(oaOrderSaveVo));
    }

    @PostMapping("/update")
    public R updateOrder(@RequestBody OaOrderSaveVo oaOrderUpdateVo) {
        return R.success().data(oaOrderService.updateOrder(oaOrderUpdateVo));
    }

    /**
     * 删除操作
     *
     * @param orderIds 订单 Id 集合
     */
    @PostMapping("/delete")
    public R deleteOrder(@RequestBody List<Long> orderIds) {
        return R.success().data(oaOrderService.deleteOrder(orderIds));
    }
}
