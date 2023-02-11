package pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/08/19:53
 * @Description:
 */
public class Demo01 {
    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();     // 单线程的线程池
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);     // 固定大小的线程池
        ExecutorService threadPool = Executors.newCachedThreadPool();   // 可变大小的线程池

        try {
            for (int i = 0; i < 100; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName() +" OK");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }


    }
}

