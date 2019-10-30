package com.hql.utils.activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author 开发者中文姓名
 * @date 2019/10/17 16:58
 * 主题模型
 * 生产者
 */
public class MessageTopicProducer {

    //定义ActiveMQ连接
    private static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    //定义发送消息的主题名称
    private static final String TOPIC_NAME = "ActiveMqTopic";

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
        Destination destination = session.createTopic(TOPIC_NAME);
        //创建一个生产者
        javax.jms.MessageProducer producer = session.createProducer(destination);
        //创建模拟100个消息
        for (int i = 1; i <= 100; i++) {
            TextMessage textMessage = session.createTextMessage("当前message是（主题模型）："+i);
            //发送消息
            producer.send(textMessage);
            //在本地打印消息
            System.out.println("我现在发的消息是:"+textMessage.getText());
        }
        //关闭连接
        connection.close();
    }
}
