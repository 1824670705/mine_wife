package com.oa;

import com.oa.application.other.service.IOaAreaService;
import com.oa.application.user.service.OaLocalUserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class OaWifeApplicationTests {

    @Autowired
    private IOaAreaService iOaAreaService;

    @Test
    void contextLoads() {
        log.info(iOaAreaService.getFullAreaName("620201100000", "-"));
    }
}
