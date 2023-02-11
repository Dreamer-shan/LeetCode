package 多线程编程实战.state;

/**
 * @author Shan
 * @Description 一定要先设置优先级再启动
 * 优先级范围为1-10，默认优先级为5，优先级越大，执行的概率越高，而不是严格按照优先级大小的顺序来执行
 * @create 2021-02-07 20:27
 */
public class TestPriority {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
        MyPriority myPriority = new MyPriority();
        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        // 先设置优先级再启动
        t1.setPriority(1);
        t2.setPriority(2);
        t3.setPriority(3);
        t4.setPriority(4);
        t5.setPriority(Thread.MAX_PRIORITY);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}


class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "--->" + Thread.currentThread().getPriority());
    }
}