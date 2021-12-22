package com.xiaobai.eurekaserviceconsume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private CartFeignClient client;

    @GetMapping("/cart")
    public String addCart(){
        LOGGER.info("被调用了");
        return client.addCart();
    }
}
