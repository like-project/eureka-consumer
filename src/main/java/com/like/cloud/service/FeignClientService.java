package com.like.cloud.service;

import com.like.cloud.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName FeignClientService
 * @Description TODO
 * @Author Ke
 * @Date 2019/10/18 18:15
 * @Version 1.0
 */
@FeignClient("cloud-client")
public interface FeignClientService {

    @GetMapping("/api/feign/{id}")
    UserVO findUser(@PathVariable int id);
}
