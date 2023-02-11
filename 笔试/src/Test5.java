import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shan
 * @Description
 * @create 2021-09-05 15:09
 */
public class Test5 {

    private LinkedList<String> lists = new LinkedList<>();
    private Lock lock = new ReentrantLock();
    private Condition prod = lock.newCondition();
    private Condition cons = lock.newCondition();

    public void put(String s) {
        lock.lock();
        try {
            // 1. 判断
            while (lists.size() != 0) {
                // 只要队列有元素，就不生产了，就停会儿
                prod.await();
            }
            // 2.干活
            lists.add(s);
            System.out.println(Thread.currentThread().getName() + " " + lists.peekFirst());
            // 3. 通知
            cons.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void get() {
        lock.lock();
        try {
            // 1. 判断
            while (lists.size() == 0) {
                // 队列为空，消费者肯定等待呀
                cons.await();
            }

            // 2.干活
            System.out.println(Thread.currentThread().getName() + " " + lists.removeFirst());
            // 3. 通知
            prod.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Test5 test = new Test5();
        for (int i = 0; i < 5; i++) {
            int tempI = i;
            new Thread(() -> {
                test.put(tempI + "");
            }, "ProdA" + i).start();
        }
        for (int i = 0; i < 5; i++) {
//            new Thread(test::get, "ConsA" + i).start();
            new Thread(()->{
                test.get();
            },"con").start();
        }
    }
}