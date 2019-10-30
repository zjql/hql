package com.hql.utils.RabbitMq.fanout_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 扇形交换机
 * 就是消息通过从交换机到队列上不会通过路由key 所以该模式的速度是最快的 只要和交换机绑定的那么消息就会 被分发到与之绑定的队列上
 * Created by smlz on 2019/9/28.
 */
public class FanoutExchangeProductor {

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
        String exchangeName = "test.fanoutexchange";

        //定义routingKey
        String routingKey = "";

        //消息体内容
        String messageBody = "hello tuling ";
        channel.basicPublish(exchangeName,"123",null,"我是第一条消息".getBytes());
        channel.basicPublish(exchangeName,"456",null,"我是第二条消息".getBytes());
        channel.basicPublish(exchangeName,"789",null,"我是第三条消息".getBytes());
    }
}
