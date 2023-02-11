package pool;

import java.util.Hashtable;
import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/08/19:53
 * @Description:
 */
public class Demo02 {
    public static void main(String[] args) {

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2,
                5,
                3,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3), Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardOldestPolicy());

        try {
            for (int i = 1; i <= 6; i++) {

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

