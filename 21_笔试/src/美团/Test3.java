package 美团;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/05/9:30
 * @Description:
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 使用synchronize wait notify/notifyAll实现生产者消费者模式
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


class ProducerAndConsumer {
    private static final int MAX_CAPACITY = 10; //阻塞队列容量
    private static BlockingQueue<Integer> blockingQueue= new ArrayBlockingQueue<>(MAX_CAPACITY); //阻塞队列
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    public void produce() throws InterruptedException {
        while (FLAG){
            boolean flag = blockingQueue.offer(atomicInteger.incrementAndGet(), 2, TimeUnit.SECONDS);
            if (flag){
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+ atomicInteger.get()+"成功"+"资源队列大小= " + blockingQueue.size());
            }else {
                System.out.println(Thread.currentThread().getName()+"\t 插入队列"+ atomicInteger.get()+"失败"+"资源队列大小= " + blockingQueue.size());

            }
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println(Thread.currentThread().getName()+"FLAG变为false，生产停止");
    }

    public void consume() throws InterruptedException {
        Integer result = null;
        while (true){
            result = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (null==result){
                System.out.println("超过两秒没有取道数据，消费者即将退出");
                return;
            }
            System.out.println(Thread.currentThread().getName()+" 消费"+ result+"成功"+" "+"资源队列大小= " + blockingQueue.size());
            Thread.sleep(1500);
        }

    }

    public void stop() {
        this.FLAG = false;
    }
}

public class Test3 {

    public static void main(String[] args) {
        ProducerAndConsumer v3 = new ProducerAndConsumer();
        new Thread(()->{
            try {
                v3.produce();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "p1").start();

        new Thread(()->{
            try {
                v3.consume();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "c1").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        v3.stop();
    }
}