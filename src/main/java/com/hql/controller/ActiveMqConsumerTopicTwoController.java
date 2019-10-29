package com.hql.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 开发者中文姓名
 * @date 2019/10/29 18:51
 */
@RestController
public class ActiveMqConsumerTopicTwoController {

    @JmsListener(destination = "active.topic")
    public void readActiveTopicMsg(String message){
        System.out.println("接收消息topic2"+message);

    }
}
