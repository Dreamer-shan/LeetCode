package com.shy.rabbitmq.fanout交换机_05;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;
import com.rabbitmq.client.Delivery;
import com.shy.rabbitmq.utils.RabbitMqUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/06/15:33
 * @Description:  ReceiveLogs02 将接收到的消息存储在磁盘
 */
public class ReceiveLogs02 {
    private final static String EXCHANGE_NAME = "logs";
    public static void main(String[] args) throws IOException, TimeoutException {
        Channel channel = RabbitMqUtils.getChannel();
        channel.exchangeDeclare(EXCHANGE_NAME, "fanout");

        // 生成一个临时队列  断开连接时队列会自动删除
        String queueName = channel.queueDeclare().getQueue();
        channel.queueBind(queueName, EXCHANGE_NAME, "");
        System.out.println("等待接收消息,把接收到的消息写到文件........... ");

        DeliverCallback deliverCallback = (String consumerTag, Delivery message) ->{
            String message1 = new String(message.getBody(), "UTF-8");
            File file = new File("rabbitmq_info.txt");
            FileUtils.writeStringToFile(file, message1, "UTF-8");
            System.out.println("数据写入文件成功");
        };
        channel.basicConsume(queueName, true, deliverCallback, consumerTag ->{});
    }
}
