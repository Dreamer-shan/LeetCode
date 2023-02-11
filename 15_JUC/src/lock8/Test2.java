package lock8;

import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/08/18:34
 * @Description:
 */
public class Test2 {
    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(()->{
            phone.sendSms();
        },"A").start();

        new Thread(()->{
            phone.hello();
        },"B").start();
    }
}

class Phone2{
    public synchronized void sendSms(){
        System.out.println("发短信");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void call(){
        System.out.println("打电话");
    }

    public void hello(){
        System.out.println("hello");
    }
}
