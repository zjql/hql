package com.hql.utils.RabbitMq.topic_exchange;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 主题交换机
 * Created by smlz on 2019/9/28.
 */
public class TopicExchangeConsumer {

    public static void main(String[] args) throws IOException, TimeoutException, InterruptedException {
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

        //声明交换机
        String exchangeName = "test.topicexchange";
        String exchangeType = "topic";
        channel.exchangeDeclare(exchangeName,exchangeType,true,true,null);

        //声明队列
        String quequName = "test.topic.queue";
        channel.queueDeclare(quequName,true,false,false,null);

        //声明绑定关系
        String bingdingStr = "test.#";
        channel.queueBind(quequName,exchangeName,bingdingStr);

        //声明一个消费者
        QueueingConsumer queueingConsumer = new QueueingConsumer(channel);

        //开始消费
        /**
         * 开始消费
         */
        channel.basicConsume(quequName,true,queueingConsumer);

        while (true) {
            QueueingConsumer.Delivery delivery = queueingConsumer.nextDelivery();
            System.out.println("接受到消息:"+new String(delivery.getBody()));
        }
    }
}
