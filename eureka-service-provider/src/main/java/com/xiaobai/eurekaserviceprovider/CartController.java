package com.xiaobai.eurekaserviceprovider;

import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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

    @Autowired
    RabbitTemplate rabbitTemplate;


    @PostMapping("/cart")
    public String addCart() {

        ConcurrentMap<Integer,Object> myMap = new ConcurrentHashMap<>(4);
        myMap.put(0,"神司马懿");
        myMap.put(1,"界徐盛");
        myMap.put(2,"曹钝");
        myMap.put(3,"骆统");
        rabbitTemplate.convertAndSend("amq.direct","2",myMap);
        LOGGER.info("被调用了");
        return "hello world!";
    }

    @RabbitListener(queues = "swl.direct")
    public void listen(ConcurrentMap<Integer,Object> msg, Message message, Channel channel){
        LOGGER.info("mq pull {}" , msg);
    }

    @RequestMapping("/hello")
    public String hello() {
        return "获取到了统一配置文件， application.name = " + value;
    }

}
