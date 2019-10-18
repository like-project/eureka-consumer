package com.like.cloud.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName ConfigBean
 * @Description TODO
 * @Author Ke
 * @Date 2019/10/17 16:58
 * @Version 1.0
 */
@Configuration
public class RibbonConfigurationBean {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }


//    @Bean
//    public IRule ribbonRule(){
//        //负载均衡规则，改为随机
//        return new RandomRule();
//    }

}
