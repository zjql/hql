package com.hql.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 开发者中文姓名
 * @date 2019/10/29 18:47
 */
@RestController
public class ActiveMqConsumerTopicController {

    /**
     * 监听和读取消息
     * @param msg
     */
    @JmsListener(destination = "ActiveMqTopic")
    public void readActiveTopicMsg(String msg){
        System.out.println("ActiveMqTopic_1接收:"+msg);
    }
}
