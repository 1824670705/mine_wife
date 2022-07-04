package com.oa.application.other.controller;

import com.oa.application.other.service.FileService;
import com.oa.utils.result.R;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * 文件管理
 */
@RequestMapping("/file")
@RestController
public class FileController {

    @Resource
    private FileService minIoFileService;

    @PostMapping("/upload")
    public R upload(@RequestParam("name") MultipartFile multipartFile) {
        return R.success().data(minIoFileService.upload(multipartFile));
    }
}
