package com.xiaobai.eurekaserviceprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @PostMapping("/cart")
    public String addCart(){
        LOGGER.info("被调用了");
        return "hello world!";
    }
}
