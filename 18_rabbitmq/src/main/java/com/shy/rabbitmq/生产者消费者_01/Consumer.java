package com.shy.rabbitmq.生产者消费者_01;

import com.rabbitmq.client.*;


import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/06/11:05
 * @Description:
 */
public class Consumer {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        factory.setUsername("guest");
        factory.setPassword("guest");
        // 获取连接
        Connection connection = factory.newConnection();
        // 通过连接获取channel
        Channel channel = connection.createChannel();



        DeliverCallback deliverCallback = (consumerTag, message) ->{
            System.out.println(new String(message.getBody()));
        };

        CancelCallback cancelCallback = (consumerTag)->{
            System.out.println("消息消费被中断");
        };

        /**
         * 消费者消费消息
         * 1.消费哪个队列  队列名
         * 2.消费成功后是否自动应答
         * 3.消费者未消费成功的回调
         * 4.消费者取消消费的回调
         */

        channel.basicConsume(QUEUE_NAME, true, deliverCallback, cancelCallback);
    }

}
