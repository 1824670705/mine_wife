package com.oa.module;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Slf4j
@SpringBootTest
public class UserModuleTest {

    @Test
    public void getBCry() {
        log.info("{}", new BCryptPasswordEncoder().encode("37@admin"));
    }
}
