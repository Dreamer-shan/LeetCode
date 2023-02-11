package pc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/08/16:52
 * @Description:生产者消费者问题
 */
// A 执行完调用B，B执行完调用C，C执行完调用A
public class C {
    public static void main(String[] args) {
        Data3 data = new Data3();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();

    }
}

class Data3{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();
    public  void printA(){
        lock.lock();
        try {
            while (number != 1){
                condition1.await();
            }
            number = 2;
            condition2.signal();
            System.out.println(Thread.currentThread().getName() + "=>" + "AAAAA");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void printB(){
        lock.lock();
        try {
            while (number != 2){
                condition2.await();
            }
            number = 3;
            condition3.signal();
            System.out.println(Thread.currentThread().getName() + "=>" + "BBBBB");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public  void printC(){
        lock.lock();
        try {
            while (number != 3){
                condition3.await();
            }
            number = 1;
            condition1.signal();
            System.out.println(Thread.currentThread().getName() + "=>" + "CCCCC");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }




}

