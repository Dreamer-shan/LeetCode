package 多线程;

/**
 * @author Shan
 * @Description
 * @create 2021-02-06 21:22
 */
public class demo01 {
    public static void main(String[] args) {
        Mythread t1 = new Mythread("t1");
        Mythread t2 = new Mythread("t2");
        Mythread t3 = new Mythread("t3");
        Mythread t4 = new Mythread("t4");
        // run 每个线程执行100次
        // start 四个线程交替执行100次
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}
