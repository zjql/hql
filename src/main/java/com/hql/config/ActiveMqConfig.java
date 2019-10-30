package com.hql.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @author 开发者中文姓名
 * @date 2019/10/30 9:42
 */
@Configuration
public class ActiveMqConfig {

    @Bean
    public Queue queue(){
        return new ActiveMQQueue("ActiveMqQueue");
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic("ActiveMqTopic");
    }
}
