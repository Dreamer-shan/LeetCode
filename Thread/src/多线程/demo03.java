package 多线程;

/**
 * @author Shan
 * @Description 避免这样做
 * @create 2021-02-06 22:04
 */
public class demo03 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("2.welcome! I'm " + Thread.currentThread().getName());
            }
        });
        t1.start();;
        t1.run();
        System.out.println("1.welcome! I'm " + Thread.currentThread().getName());
    }
}
