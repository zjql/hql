package com.hql.controller;

import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.broker.region.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @author 开发者中文姓名
 *
 * 队列消息控制器
 * @date 2019/10/29 18:30
 */
@RestController
public class ActiveMqProviderController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Autowired
    private Topic topic;

    @RequestMapping("/sendmsg")
    public void sendMsg(String msg){
        this.jmsMessagingTemplate.convertAndSend((Destination) this.queue,msg);
    }

    @RequestMapping("/send")
    public void send(String msg){
        this.jmsMessagingTemplate.convertAndSend((Destination) this.topic,msg);
    }
}
