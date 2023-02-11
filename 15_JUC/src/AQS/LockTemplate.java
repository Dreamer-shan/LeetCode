package AQS;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/11/16:16
 * @Description:
 */
public class LockTemplate {
    private int count = 0;
    private ReentrantLock lock = new ReentrantLock(true);
    public static void main(String[] args) {
        LockTemplate tp = new LockTemplate();
        new Thread(()->{
            String threadName = Thread.currentThread().getName();
            tp.modifyResource(threadName);
        },"111").start();
    }

    public void modifyResource(String threadName){
        System.out.println("通知<<管理员>>线程" + threadName + "准备打水");
        lock.lock();
        try {
            System.out.println("线程" + threadName + "第一次加锁");
            count++;
            System.out.println("线程" + threadName + "打第" + count + "桶水");
            lock.lock();
            System.out.println("线程" + threadName + "第二次加锁");
            count++;
            System.out.println("线程" + threadName + "打第" + count + "桶水");
            lock.unlock();
            System.out.println("线程" + threadName + "释放一个锁");

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
            System.out.println("线程" + threadName + "释放一个锁");
        }
    }

}
