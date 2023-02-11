package 多线程编程实战.syn;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shan
 * @Description ArrayList是线程不安全的
 * 往里添加，如果线程安全，最后应该是list.size()==10000
 * 两个线程同一时间添加到了同一位置，导致直接在原位置上覆盖了
 * @create 2021-02-07 21:37
 */
public class UnsafeList {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
