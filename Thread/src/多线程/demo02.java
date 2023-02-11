package 多线程;

/**
 * @author Shan
 * @Description
 * @create 2021-02-06 21:35
 */
public class demo02 {
    public static void main(String[] args) {
        MyRunnable my1 = new MyRunnable("t1");
        MyRunnable my2 = new MyRunnable("t2");
        MyRunnable my3 = new MyRunnable("t3");
        Thread t1 = new Thread(my1);
        Thread t2 = new Thread(my2);
        Thread t3 = new Thread(my3);
        t1.start();
        t2.start();
        t3.start();

    }
}
