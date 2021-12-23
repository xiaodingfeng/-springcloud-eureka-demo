package com.xiaobai.eurekaserviceprovider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dingfeng.xiao
 */
@RestController
public class CartController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);

    @Autowired
    private Environment env;

    @Value("${spring.application.name}")
    private String value;

    @PostMapping("/cart")
    public String addCart() {
        LOGGER.info("被调用了");
        return "hello world!";
    }


    @RequestMapping("/hello")
    public String hello() {
        return "获取到了统一配置文件， application.name = " + value;
    }

}
