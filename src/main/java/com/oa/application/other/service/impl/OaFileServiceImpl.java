package com.oa.application.other.service.impl;

import com.oa.application.other.service.FileService;
import com.oa.domain.mapper.OaFileMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * (OaFile)表服务实现类
 *
 * @author makejava
 * @since 2022-07-10 18:05:12
 */
@Service("oaFileService")
public class OaFileServiceImpl implements FileService {

    @Resource
    private OaFileMapper oaFileMapper;

    @Override
    public String upload(MultipartFile multipartFile) {
        return null;
    }
}
