package com.xiaobai.eurekaserviceconsume;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author dingfeng.xiao
 */
@FeignClient(value = "eureka-service-provider")
public interface CartFeignClient {

    /**
     * 调用接口
     * @return String
     */
    @PostMapping("/cart")
    String addCart();
}
