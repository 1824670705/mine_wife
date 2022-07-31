package com.oa.application.log.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oa.application.log.entity.bo.Log;
import com.oa.application.log.entity.dto.LogListDto;
import com.oa.application.log.service.LogService;
import com.oa.domain.mapper.OaLogMapper;
import org.springframework.stereotype.Service;

@Service("logService")
public class LogServiceImpl extends ServiceImpl<OaLogMapper, Log> implements LogService {

    @Override
    public IPage<Log> getList(LogListDto logListDto) {
        Page<Log> page = new Page<>(logListDto.getPageIndex(), logListDto.getPageSize());
        return page(page);
    }
}
