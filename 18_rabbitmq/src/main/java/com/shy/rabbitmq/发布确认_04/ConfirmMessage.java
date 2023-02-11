package com.shy.rabbitmq.发布确认_04;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.ConfirmCallback;
import com.shy.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/06/13:37
 * @Description:发布确认模式 1.单个确认
 * 2.批量确认
 * 3.异步批量确认
 */
public class ConfirmMessage {
    public static final int MESSAGE_COUNT = 1000;

    public static void main(String[] args) throws InterruptedException, TimeoutException, IOException {
//        ConfirmMessage.publishMessageIndividually();
//        ConfirmMessage.publishMessageBatch();
        ConfirmMessage.publishMessageAsync();
    }

    public static void publishMessageIndividually() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, true, false, false, null);
        // 开启发布确认
        channel.confirmSelect();
        // 开始时间
        long begin = System.currentTimeMillis();

        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String massage = i + " ";
            channel.basicPublish("", queueName, null, massage.getBytes());
            //发布确认    服务端返回 false 或超时时间内未返回，生产者可以消息重发
            boolean flag = channel.waitForConfirms();
            if (flag) {
                System.out.println("消息发送成功");
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个单独确认消息，耗时 " + (end - begin) + " ms");
    }

    public static void publishMessageBatch() throws IOException, TimeoutException, InterruptedException {
        Channel channel = RabbitMqUtils.getChannel();
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        channel.confirmSelect();
        int batchSize = 100;
        long begin = System.currentTimeMillis();
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = i + " ";
            channel.basicPublish("", queueName, null, message.getBytes());
            if (i % batchSize == 0) {
                boolean flag = channel.waitForConfirms();
                if (flag) {
                    System.out.println("消息发送成功");
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个单独确认消息，耗时 " + (end - begin) + " ms");
    }

    public static void publishMessageAsync() throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        // 队列声明
        String queueName = UUID.randomUUID().toString();
        channel.queueDeclare(queueName, false, false, false, null);
        channel.confirmSelect();
        // 并发有序哈希表   键值对为  序号--消息
        ConcurrentSkipListMap<Long, String> map = new ConcurrentSkipListMap<>();



        // 消息确认成功的回调
        ConfirmCallback ackCallback = (long deliveryTag, boolean multiple) -> {
            if (multiple){
                // 删除已经确认的消息  剩下的就是未确认的
                ConcurrentNavigableMap<Long, String> confirmed = map.headMap(deliveryTag);

                confirmed.clear();
            }else {
                map.remove(deliveryTag);
            }
            System.out.println("确认的消息" + deliveryTag);
        };

        // 消息确认失败的回调
        ConfirmCallback nackCallback = (long deliveryTag, boolean multiple) -> {
            String message = map.get(deliveryTag);
            System.out.println("未确认的消息" + message + "未确认的消息tag" + deliveryTag);
        };
        long begin = System.currentTimeMillis();
        // 监听器
        channel.addConfirmListener(ackCallback, nackCallback);
        for (int i = 0; i < MESSAGE_COUNT; i++) {
            String message = "消息" + i;
            channel.basicPublish("", queueName, null, message.getBytes());
            // 记录所有要发送的消息
            map.put(channel.getNextPublishSeqNo(), message);
        }
        long end = System.currentTimeMillis();
        System.out.println("发布" + MESSAGE_COUNT + "个单独确认消息，耗时 " + (end - begin) + " ms");
    }
}

