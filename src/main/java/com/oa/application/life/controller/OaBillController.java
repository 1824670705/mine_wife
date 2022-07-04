package com.oa.application.life.controller;

import com.oa.application.life.entity.bo.OaBill;
import com.oa.application.life.service.OaBillService;
import com.oa.application.life.entity.dto.OaBillListDto;
import com.oa.utils.result.R;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/bill")
public class OaBillController {

    @Resource
    private OaBillService oaBillService;

    @GetMapping("/list")
    public R getList(@Validated OaBillListDto oaBillListVo) {
        return R.success().data(oaBillService.getList(oaBillListVo));
    }

    @PostMapping("/save")
    public R saveBill(@RequestBody OaBill oaBill) {
        return R.success().data(oaBillService.saveBill(oaBill));
    }

    @PostMapping("/update")
    public R update(@RequestBody OaBill oaBill) {
        return R.success().data(oaBillService.updateById(oaBill));
    }

    @PostMapping("/delete")
    public R update(@RequestBody List<Long> billIds) {
        return R.success().data(oaBillService.removeByIds(billIds));
    }
}
