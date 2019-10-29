package com.hql.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 开发者中文姓名
 * @date 2019/10/29 18:42
 * 客户控制器
 */
@RestController
public class ActiveMqConsumerController {

    @JmsListener(destination = "active.queue")
    public void readActiveQueue(String message){
        System.out.println("接收到的mq:"+message);
    }
}
