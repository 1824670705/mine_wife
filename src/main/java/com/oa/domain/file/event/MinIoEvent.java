package com.oa.domain.file.event;

import io.minio.GetPresignedObjectUrlArgs;
import io.minio.MinioClient;
import io.minio.PutObjectArgs;
import io.minio.http.Method;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class MinIoEvent {

    @Resource
    private MinioClient minioClient;
    private final String bucketName = "oa-wife";

    /**
     * 文件上传
     *
     * @param multipartFiles 上传事件
     * @return 上传以后的地址
     */
    public List<String> minIoUpload(List<MultipartFile> multipartFiles) throws Exception {
        List<String> urlList = new ArrayList<>(multipartFiles.size());
        for (MultipartFile multipartFile : multipartFiles) {
            String contentType = multipartFile.getContentType();
            String originalFilename = System.currentTimeMillis() + "_" + multipartFile.getOriginalFilename();
            String obj = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(LocalDate.now()) + "/" + originalFilename;
            InputStream inputStream = multipartFile.getInputStream();
            minioClient.putObject(
                    PutObjectArgs.builder()
                            .bucket(bucketName)
                            .contentType(contentType)
                            .object(obj)
                            .stream(inputStream, inputStream.available(), -1)
                            .build()
            );
            urlList.add("http://129.151.117.242:9000/oa-wife/" + obj);
        }
        return urlList;
    }

    /**
     * 获取文件外链
     *
     * @param oriName 文件名字
     * @return 外链
     */
    public String getFileUrl(String oriName) throws Exception {
        return minioClient.getPresignedObjectUrl(
                GetPresignedObjectUrlArgs.builder()
                        .bucket(bucketName)
                        .method(Method.GET)
                        .object(oriName)
                        .expiry(30)
                        .build()
        );
    }
}
