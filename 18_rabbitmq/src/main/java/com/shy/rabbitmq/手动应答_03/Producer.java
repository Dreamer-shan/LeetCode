package com.shy.rabbitmq.手动应答_03;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.MessageProperties;
import com.shy.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/06/11:05
 * @Description:
 */
public class Producer {
    private final static String QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();

        // 声明队列
        /**
         * 1.队列名称
         * 2.队列消息是否持久化，默认消息存储在内存中
         * 3.该队列是否只供一个消费者进行消费 是否进行共享 true 可以多个消费者消费
         * 4.是否自动删除  最后一个消费者端开连接以后 该队列是否自动删除 true 自动删除
         * 5.其他参数
         */
        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String message = sc.next();
            //  默认是保存在内存中  设置生产者发送消息为持久化消息  让消息保存到磁盘中
            channel.basicPublish("",QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes());
            System.out.println("消息发送完毕");
        }
    }

}
