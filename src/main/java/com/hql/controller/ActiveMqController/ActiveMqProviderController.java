package com.hql.controller.ActiveMqController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;
import javax.jms.Topic;

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

    @RequestMapping("/send")
    public void sendMsg(String msg){
        this.jmsMessagingTemplate.convertAndSend(this.queue,msg);
    }

    @RequestMapping("/sendTopic")
    public void send(String msg){
        this.jmsMessagingTemplate.convertAndSend(this.topic,msg);
    }
}
