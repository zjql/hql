package com.hql.utils.activeMq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author 开发者中文姓名
 * @date 2019/10/17 17:11
 * 主题模式
 * 消费者
 */
public class MessageTopicConsumer {

    //定义ActiveMQ连接
    private static final String ACTIVEMQ_URL = "tcp://127.0.0.1:61616";
    //定义接收消息的主题名称
    private static final String TOPIC_NAME = "ActiveMqTopic";

    public static void main(String[] args) throws JMSException {
        //创建工厂连接
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        //创建连接
        Connection connection = activeMQConnectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建队列目标
        Destination destination = session.createTopic(TOPIC_NAME);
        //创建一个消费者
        javax.jms.MessageConsumer consumer = session.createConsumer(destination);
        //创建消息的监听
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                try {
                    System.out.println("获取消息："+textMessage.getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
