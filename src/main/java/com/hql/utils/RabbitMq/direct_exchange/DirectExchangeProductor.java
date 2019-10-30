package com.hql.utils.RabbitMq.direct_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 直连交换机模式
 * 所有发送的directexhchange 的消息都会被投递到与routekey名称(与队列名称)相同的queue上
 * direct模式下，可以使用rabbitmq自定exchange----> default exchange 所以不需要交换机和任何队列绑定,
 * Created by smlz on 2019/9/28.
 */
public class DirectExchangeProductor {

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

        //定义交换机名称
        String exchangeName = "test.directchange";

        //定义routingKey
        String routingKey = "test.directchange.key";

        //消息体内容
        String messageBody = "hello tuling ";
        channel.basicPublish(exchangeName,routingKey,null,messageBody.getBytes());

    }
}
