package demo01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/08/16:29
 * @Description:基本卖票例子
 */
public class SaleTicketDemo02 {
    public static void main(String[] args) {
        Ticket2 ticket = new Ticket2();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "A").start();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "B").start();
        new Thread(()->{
            for (int i = 0; i < 60; i++) {
                ticket.sale();
            }
        }, "C").start();
    }
}

// lock
/*
* lock三部曲  new对象   加锁   释放锁
* */
class Ticket2{
    Lock lock = new ReentrantLock();
    private int number = 50;
    public  void sale(){
        lock.lock();
        try{
            if (number > 0){
                System.out.println(Thread.currentThread().getName() + "卖出了第" + (number--) + "张票, 剩余:" + number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}