package com.oa.infrastructure.redis.hanlder;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.lang.Nullable;

/**
 * 缓存异常处理
 */
@Slf4j
public class RedisErrorHandler implements CacheErrorHandler {


    @Override
    public void handleCacheGetError(RuntimeException exception, @Nullable Cache cache, @Nullable Object key) {
        log.error("redis get 【key={}】 error, ---> {}", key, exception.getMessage());
    }

    @Override
    public void handleCachePutError(RuntimeException exception, @Nullable Cache cache, @Nullable Object key, Object value) {
        log.error("redis put 【key={}】 error, ---> {}", key, exception.getMessage());
    }

    @Override
    public void handleCacheEvictError(RuntimeException exception, @Nullable Cache cache, @Nullable Object key) {
        log.error("redis evict 【key={}】 error, ---> {}", key, exception.getMessage());
    }

    @Override
    public void handleCacheClearError(RuntimeException exception, @Nullable Cache cache) {
        log.error("redis cache clear error, ---> {}", exception.getMessage());
    }
}
