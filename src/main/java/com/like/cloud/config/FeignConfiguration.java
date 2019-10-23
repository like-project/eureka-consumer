package com.like.cloud.config;

import feign.Contract;
import feign.auth.BasicAuthRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfiguration
 * @Description 自定义feign配置
 * @Author Ke
 * @Date 2019/10/23 11:32
 * @Version 1.0
 */
@Configuration
public class FeignConfiguration {

    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor(){
        return new BasicAuthRequestInterceptor("user","password");
    }

//    @Bean
//    public Contract feignContract(){
//        return new feign.Contract.Default();
//    }
}
