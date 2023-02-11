package 多线程;

/**
 * @author Shan
 * @Description
 * @create 2021-02-06 21:33
 */
public class MyRunnable implements Runnable{
    private String name;
    public MyRunnable(String name){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "--" + i);
        }
    }
}
