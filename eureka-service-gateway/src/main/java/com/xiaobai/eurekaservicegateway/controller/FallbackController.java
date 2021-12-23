package com.xiaobai.eurekaservicegateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dingfeng.xiao
 */
@RestController
@RequestMapping("/circuitBreaker")
public class FallbackController {

    @RequestMapping("/fallback")
    public String fallback() {
        return "服务暂时不可用";
    }
}
