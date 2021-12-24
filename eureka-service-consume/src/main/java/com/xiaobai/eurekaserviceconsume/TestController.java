package com.xiaobai.eurekaserviceconsume;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dingfeng.xiao
 */
@RestController
public class TestController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

    @Resource
    private CartFeignClient client;

    @GetMapping("/cart")
    public String addCart() {
        LOGGER.info("被调用了");
        return client.addCart();
    }
}
