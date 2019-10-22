package com.like.cloud.service;

import com.like.cloud.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName FeignHystrixClientService
 * @Description TODO
 * @Author Ke
 * @Date 2019/10/21 16:48
 * @Version 1.0
 */
@FeignClient(value = "cloud-provider",fallbackFactory = ClientFallbackFactory.class)
public interface FeignHystrixClientService {

    @GetMapping("/api/feignHystrix/{id}")
    UserVO findUser(@PathVariable int id);
}
