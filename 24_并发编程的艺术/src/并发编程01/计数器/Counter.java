package 并发编程01.计数器;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Counter {
    private AtomicInteger atomicI = new AtomicInteger(0);
    private int i = 0;

    public static void main(String[] args) {
        Counter cas = new Counter();
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 100; j++) {
                        cas.count();
                        cas.safeCount();
                    }
                }
            });
            list.add(t1);
        }
        for (Thread thread : list) {
            thread.start();
        }
        for (Thread thread : list) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(cas.i);
        System.out.println(cas.atomicI.get());
    }

    private void count() {
        i++;
    }

    private void safeCount() {
        for (; ; ) {
            int i = atomicI.get();
            boolean flag = atomicI.compareAndSet(i, ++i);
            if (flag) {
                break;
            }
        }
    }

}
