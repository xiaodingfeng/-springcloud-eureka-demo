package com.xiaobai.eurekaserviceconsume;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author dingfeng.xiao
 */
@FeignClient(value = "eureka-service-provider")
public interface CartFeignClient {

    @PostMapping("/cart")
    String addCart();
}
