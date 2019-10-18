package com.like.rule;

import com.like.cloud.config.RoundRuless;
import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MyRibbonRule
 * @Description 自定义负载均衡策略 需实现接口 IRule
 * @Author Ke
 * @Date 2019/10/18 15:00
 * @Version 1.0
 */
@Configuration
public class MyRibbonRule{

    @Bean
    public IRule ribbonRule(){
        //return new RoundRobinRule();//轮询
        //return new RandomRule();
        return new RoundRuless();
    }



}
