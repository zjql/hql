package com.hql.utils.RabbitMq.topic_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 *
 * 就是在队列上绑到topic交换机上的路由key
 * 可以是通过通配符来匹配的通配符的规则是如下:
 * log.*:可以匹配一个单词 比如--->log.* 可以匹配log.a 但是不可以匹配log.a.b
 * log.#:可以匹配一个单词,也可以匹配多个单词 比如--->log.# 可以匹配log.a log.a.b log.a.b
 * Created by smlz on 2019/9/28.
 */
public class TopicExchangeProductor {

    public static void main(String[] args) throws IOException, TimeoutException {

        //创建连接工厂
        ConnectionFactory connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("101.200.44.140");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("test");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("123456");

        //创建连接
        Connection connection = connectionFactory.newConnection();

        //创建channel
        Channel channel = connection.createChannel();

        //发送消息
        String exchangeName = "test.topicexchange";

        String routingKey1 = "test.key1";
        String routingKey2 = "test.key2";
        String routingKey3 = "test.key.key3";

        channel.basicPublish(exchangeName,routingKey1,null,"我是第一条消息".getBytes());
        channel.basicPublish(exchangeName,routingKey2,null,"我是第二条消息".getBytes());
        channel.basicPublish(exchangeName,routingKey3,null,"我是第三条消息".getBytes());
    }
}
