package com.like.cloud.controller;

import com.like.cloud.service.FeignClientService;
import com.like.cloud.service.FeignHystrixClientService;
import com.like.cloud.vo.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName FeignController
 * @Description TODO
 * @Author Ke
 * @Date 2019/10/18 18:14
 * @Version 1.0
 */
@RestController
public class FeignController {

    @Autowired
    private FeignClientService feignClientService;
    @Autowired
    private FeignHystrixClientService feignHystrixClientService;


    @GetMapping("/feign/{id}")
    public UserVO feignTransfer(@PathVariable int id){
        UserVO user = feignClientService.findUser(id);
        return user;
    }



    @GetMapping("/feignOfHystrix/{id}")
    public UserVO feignOfHystrix(@PathVariable int id){
        UserVO user = feignHystrixClientService.findUser(id);
        return user;
    }
}



