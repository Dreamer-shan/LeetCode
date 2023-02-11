package com.shy.rabbitmq.手动应答_03;

import com.rabbitmq.client.CancelCallback;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.shy.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/06/12:59
 * @Description:
 */
public class Work01 {
    private static final String QUEUE_NAME = "ack_queue";

    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        System.out.println("C1处理时间较短");
        DeliverCallback deliverCallback = (String consumerTag, Delivery message) ->{
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("接收到消息" + new String(message.getBody()));
            // 消息的标记 tag   是否批量应答
            channel.basicAck(message.getEnvelope().getDeliveryTag(), false);
        };
        // 设置不公平分发
//        int prefetchCount = 1;
        // 预取值是2
        int prefetchCount = 2;
        channel.basicQos(prefetchCount);
        CancelCallback cancelCallback = (String consumerTag) ->{
            System.out.println(consumerTag + "消费者取消消费接口回调逻辑");
        };
        boolean autoAck = false;
        channel.basicConsume(QUEUE_NAME, autoAck, deliverCallback, cancelCallback);
    }
}
