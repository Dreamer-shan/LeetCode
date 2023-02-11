package com.shy.rabbitmq.fanout交换机_05;

import com.rabbitmq.client.Channel;
import com.shy.rabbitmq.utils.RabbitMqUtils;

import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/06/15:49
 * @Description:  EmitLog 发送消息给两个消费者接收
 */
public class EmitLog {
    private final static String EXCHANGE_NAME = "logs";
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String message = sc.next();
            channel.basicPublish(EXCHANGE_NAME,"",null, message.getBytes("UTF-8"));
            System.out.println("生产者发出消息" + message);
        }
    }
}
