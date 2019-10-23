package com.like.cloud.service;

import com.like.cloud.config.FeignConfiguration;
import com.like.cloud.vo.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "cloud-client",configuration = FeignConfiguration.class)
public interface FeignConfigService {

    @GetMapping("/api/feign/{id}")
    UserVO findUser(@PathVariable int id);
}
