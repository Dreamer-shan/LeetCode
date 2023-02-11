package 多线程;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/05/13:52
 * @Description:
 */
public class Practice {
    private LinkedList<Integer> list = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition pro = lock.newCondition();
    private Condition con = lock.newCondition();
    public void put(int s){
        lock.lock();
        try {
            while (list.size() != 0){
                pro.await();
            }
            list.add(s);
            System.out.println(Thread.currentThread().getName()+"生产了"+list.peekFirst());
            con.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    
    public void get(){
        lock.lock();
        try {
            while (list.size() == 0){
                con.await();
            }
            System.out.println(Thread.currentThread().getName() + "消费了 " + list.removeFirst());
            pro.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Practice practice = new Practice();
        for (int i = 0; i < 5; i++) {
            int temp = i;
            new Thread(()->{
                practice.put(temp);
            }, "生产者" + i).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                practice.get();
            },"消费者" + i).start();
        }
    }
}
