package com.stackroute.pie.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
//
//@Configuration
//@EnableCaching
//@EnableAutoConfiguration
//public class CachingConfig {
//
//
//        @Bean
//        public CacheManager cacheManager() {
//
//            Cache cache = new ConcurrentMapCache("Policy");
//            System.out.println("Used caching config");
//            SimpleCacheManager manager = new SimpleCacheManager();
//            manager.setCaches(Arrays.asList(cache));
//
//            return manager;
//        }
//    }

