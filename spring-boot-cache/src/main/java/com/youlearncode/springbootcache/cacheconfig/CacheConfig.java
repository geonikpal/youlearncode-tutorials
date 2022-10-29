package com.youlearncode.springbootcache.cacheconfig;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.boot.autoconfigure.cache.Cache2kBuilderCustomizer;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.cache.interceptor.CacheOperationInvocationContext;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.interceptor.NamedCacheResolver;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import java.util.Arrays;
import java.util.Collections;

import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    @Bean("keyGenerator")
    public KeyGenerator keyGenerator(){
        return (target, method, params) -> target + method.getName() + Arrays.toString(params);
    }

    @Bean("brandFilterCacheManager")
    @Primary
    public CacheManager brandCacheManager(){
        return getCacheManager("brandFilterCache", 10, 5);
    }

    @Bean("priceFilterCacheManager")
    public CacheManager priceCacheManager(){
       return getCacheManager("priceFilterCache", 2, 3);
    }

    @Bean("priceFilterCacheResolver")
    public CacheResolver priceCacheResolver(){
        return new NamedCacheResolver(priceCacheManager(), "priceFilterCache");
    }

    private CacheManager getCacheManager(String cacheName, int secondsExpiry, long entriesSize) {
        CaffeineCache cache = buildCache(cacheName, secondsExpiry, entriesSize);
        SimpleCacheManager manager = new SimpleCacheManager();
        manager.setCaches(Collections.singleton(cache));
        return manager;
    }

    private CaffeineCache buildCache(String cacheName, int secondsExpiry, long entriesSize){
        return new CaffeineCache(
                    cacheName,
                    Caffeine
                            .newBuilder()
                            .expireAfterWrite(secondsExpiry, TimeUnit.SECONDS)
                            .maximumSize(entriesSize)
                            .build()
        );
    }

}