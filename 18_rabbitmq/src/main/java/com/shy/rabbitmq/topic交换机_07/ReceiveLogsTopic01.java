package com.shy.rabbitmq.topic交换机_07;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.shy.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/06/18:22
 * @Description:
 */
public class ReceiveLogsTopic01 {
    private static final String EXCHANGE_NAME = "topic_logs";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        // 声明交换机
        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
        // 队列
        String queueName = "Q1";
        channel.queueDeclare(queueName, false, false, false, null);
        // 绑定队列
        channel.queueBind(queueName, EXCHANGE_NAME, "*.orange.*");
        System.out.println("等待接收消息");
        DeliverCallback deliverCallback = (String consumerTag, Delivery message) ->{
            System.out.println(" 接 收 队 列 :"+queueName+" 绑定键:"+message.getEnvelope().getRoutingKey()+",消息:"+new String(message.getBody()));
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag -> {});
    }
}
