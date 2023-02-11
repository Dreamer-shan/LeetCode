package lock8;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/08/18:34
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        new Thread(()->{
            try {
                phone.call();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();
    }
}

class Phone{
    public synchronized void sendSms(){
        System.out.println("发短信");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void call() throws InterruptedException {
        Thread.sleep(10000);
        System.out.println("打电话");
    }
}
