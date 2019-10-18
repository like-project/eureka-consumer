package com.like.cloud;

import com.like.rule.MyRibbonRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * RibbonClient 自定义Ribbon负载均衡策略
 * 在启动该微服务时就能去加载自定义Ribbon配置类，从而配置生效
 */

@SpringBootApplication
//@EnableDiscoveryClient
@EnableEurekaClient
@RibbonClient(name = "cloud-client",configuration = MyRibbonRule.class)
public class CloudProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudProviderApplication.class, args);
    }

}
