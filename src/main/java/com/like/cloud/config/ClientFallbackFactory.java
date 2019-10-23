package com.like.cloud.config;

import com.like.cloud.service.FeignHystrixClientService;
import com.like.cloud.vo.UserVO;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @ClassName ClientFallbackFactory
 * @Description hystrix服务降级
 * @Author Ke
 * @Date 2019/10/21 16:49
 * @Version 1.0
 */
@Component
public class ClientFallbackFactory implements FallbackFactory<FeignHystrixClientService> {
    @Override
    public FeignHystrixClientService create(Throwable throwable) {
        return new FeignHystrixClientService() {
            @Override
            public UserVO findUser(int id) {
                UserVO userVO = new UserVO();
                userVO.setId(id);
                userVO.setName("return fail: service provide 降级");
                return userVO;
            }
        };
    }
}
