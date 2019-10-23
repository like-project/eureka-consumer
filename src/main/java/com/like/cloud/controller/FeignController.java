package com.like.cloud.controller;

import com.like.cloud.service.FeignClientService;
import com.like.cloud.service.FeignConfigService;
import com.like.cloud.service.FeignHystrixClientService;
import com.like.cloud.vo.UserVO;
import feign.RequestLine;
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
//    @Autowired
//    private FeignConfigService feignConfigService;


    @GetMapping("/feign/{id}")
    public UserVO feignTransfer(@PathVariable int id){
        UserVO user = feignClientService.findUser(id);
        return user;
    }

    /**
     * @MethodName feignOfHystrix
     * @Description todo 自定义fiegn未完成
     * @params [id]
     * @Return com.like.cloud.vo.UserVO
     * @exception
     * @Author Ke
     * @Version V1.0.0
     * @Date 2019/10/23 15:04
     */
//    @RequestLine("/feignConfig/{id}")
//    public UserVO feignConfigTransfer(@PathVariable int id){
//        System.out.println("id="+ id);
//        UserVO user = feignConfigService.findUser(id);
//        return user;
//    }



    @GetMapping("/feignOfHystrix/{id}")
    public UserVO feignOfHystrix(@PathVariable int id){
        UserVO user = feignHystrixClientService.findUser(id);
        return user;
    }
}



