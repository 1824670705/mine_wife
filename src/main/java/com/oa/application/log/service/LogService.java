package com.oa.application.log.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.oa.application.log.entity.bo.Log;
import com.oa.application.log.entity.dto.LogListDto;

public interface LogService extends IService<Log> {

    IPage<Log> getList(LogListDto logListDto);
}
