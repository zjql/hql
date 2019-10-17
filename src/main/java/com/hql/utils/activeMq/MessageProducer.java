package com.hql.utils.activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;


/**
 * @author 开发者中文姓名
 * @date 2019/10/17 15:18
 * 队列模型
 * 消息生产者
 */
public class MessageProducer {

    //定义activeMQ的连接地址
    private static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";

    //定义发送消息得队列名称
    private static final String QUEUE_NAME = "MyMessage";

    public static void main(String[] args) throws JMSException {
        //创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建一个生成者
        javax.jms.MessageProducer producer = session.createProducer(destination);
        //创建模拟100个消息
        for (int i = 1; i <= 100; i++) {
            TextMessage textMessage = session.createTextMessage("我发送Message："+i);
            //发送消息
            producer.send(textMessage);
            //在本地打印消息
            System.out.println("我现在发得消息是："+textMessage.getText());
        }
        //关闭连接
        connection.close();
    }
}
