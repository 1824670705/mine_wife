package com.oa.domain.file.config;

import io.minio.MinioClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinIoConfig {

    private final String endpoint = "http://129.151.117.242:9000";
    private final String accessKey = "XK4GYI0D4XISS6DFEFE8";
    private final String secretKey = "JrncORW+dOq8O5M+KNwrLmdHIuHX0t5Z+9WfvvHM";

    @Bean
    public MinioClient minioClient() {
        return MinioClient.builder().endpoint(endpoint).credentials(accessKey, secretKey).build();
    }
}
