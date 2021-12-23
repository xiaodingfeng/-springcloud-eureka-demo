package com.xiaobai.eurekaserviceconsume;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dingfeng.xiao
 */
@RestController
public class TestController {
    @Autowired
    private CartFeignClient client;

    @GetMapping("/cart")
    public String addCart() {
        return client.addCart();
    }
}
