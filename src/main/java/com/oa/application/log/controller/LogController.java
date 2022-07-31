package com.oa.application.log.controller;

import com.oa.application.log.entity.dto.LogListDto;
import com.oa.application.log.service.LogService;
import com.oa.utils.result.R;
import com.oa.utils.validate.Default;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/log")
public class LogController {

    @Resource(name = "logService")
    private LogService logService;

    @GetMapping("/list")
    public R getList(@Validated(Default.class) LogListDto logListDto) {
        return R.success().data(logService.getList(logListDto));
    }
}
