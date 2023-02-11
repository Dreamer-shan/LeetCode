package 多线程编程实战.syn;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Shan
 * @Description 测试JUC安全类型的集合
 * @create 2021-02-07 22:29
 */
public class TestJUC {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        System.out.println(list.size());
    }
}
