package com.oa.application.other.service;

import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String upload(MultipartFile multipartFile);
}
