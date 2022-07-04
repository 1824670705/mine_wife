package com.oa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.oa.domain.mapper")
@SpringBootApplication
public class OaWifeApplication {

    public static void main(String[] args) {
        SpringApplication.run(OaWifeApplication.class, args);
    }

}
