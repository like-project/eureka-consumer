package com.like.cloud.controller;

import com.like.cloud.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName DemoController
 * @Description TODO
 * @Author Ke
 * @Date 2019/10/17 18:56
 * @Version 1.0
 */
@RestController
public class RibbonController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/ribbon/{id}")
    public UserVO demo(@PathVariable int id){
        return restTemplate.getForObject("http://cloud-client/api/ribbon/"+ id, UserVO.class);
    }

    @GetMapping("/log-instance")
    public String logUserInstance(){
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("cloud-client");
        String str = serviceInstance.getServiceId() + "#" + serviceInstance.getHost() + "#" + serviceInstance.getPort();
        return str;
    }

}
