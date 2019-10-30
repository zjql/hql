package com.hql.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 开发者中文姓名
 * @date 2019/10/29 18:42
 * 客户控制器
 */
@RestController
public class ActiveMqConsumerController {

    @JmsListener(destination = "ActiveMqQueue")
    public void readActiveQueue(String msg){
        System.out.println("ActiveMqQueue接收:"+msg);
    }

    //sendTo 会将此方法返回的数据  写入到OutQueue中去
    @SendTo("SQueue")
    @JmsListener(destination = "ActiveMqQueue")
    public String readActiveQueue2(String message){
        System.out.println("ActiveMqQueue2接收:"+message);
        return message;
    }
}
