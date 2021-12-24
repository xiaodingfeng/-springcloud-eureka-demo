package com.xiaobai.eurekaserviceprovider;

import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

/**
 * @author dingfeng.xiao
 */
@SpringBootApplication
@EnableDiscoveryClient
public class EurekaServiceProviderApplication {

    @Bean
    public MessageConverter getMessageConverter(){
        return new Jackson2JsonMessageConverter();
    }


    public static void main(String[] args) {
        SpringApplication.run(EurekaServiceProviderApplication.class, args);

    }

}
