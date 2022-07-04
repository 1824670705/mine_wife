package com.oa.application.other.service.impl;

import com.oa.application.other.service.FileService;
import com.oa.domain.file.event.MinIoEvent;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Collections;

/**
 * MinIO 文件上传系统
 */
@Service("/minIoFileService")
public class MinIOFileServiceImpl implements FileService {

    @Resource
    private MinIoEvent minIoEvent;

    /**
     * 文件上传
     *
     * @param multipartFile 文件
     * @return 访问路径
     */
    @Override
    public String upload(MultipartFile multipartFile) {
        try {
            return minIoEvent.minIoUpload(Collections.singletonList(multipartFile)).get(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
