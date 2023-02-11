package 多线程编程实战.JUC;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Shan
 * @Description
 * @create 2021-02-08 11:11
 */
public class TestLock {
    public static void main(String[] args) {
        TestLock2 testLock2 = new TestLock2();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
        new Thread(testLock2).start();
    }
}

class TestLock2 implements Runnable {
    int tickets = 10;
    private final ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            lock.lock();
            try {
                if (tickets > 0) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(tickets--);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }

        }
    }
}
