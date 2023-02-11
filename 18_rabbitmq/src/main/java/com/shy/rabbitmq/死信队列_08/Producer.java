package com.shy.rabbitmq.死信队列_08;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.shy.rabbitmq.utils.RabbitMqUtils;
import sun.misc.Unsafe;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/06/20:14
 * @Description:
 */
public class Producer {
    private static final String NORMAL_EXCHANGE = "normal_exchange";
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        // 死信消息  设置TTL时间  10s
//        AMQP.BasicProperties properties = new AMQP.BasicProperties().builder().expiration("10000").build();
        for (int i = 1; i < 11; i++) {
            String message = "info " + i;
//            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", properties, message.getBytes());
            channel.basicPublish(NORMAL_EXCHANGE, "zhangsan", null, message.getBytes());
            System.out.println("生产者发送消息:" + message);
        }

    }
}
