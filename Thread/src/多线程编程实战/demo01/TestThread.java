package 多线程编程实战.demo01;

/**
 * @author Shan
 * @Description
 * @create 2021-02-07 15:34
 */
public class TestThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {

        TestThread t1 = new TestThread();
        t1.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}
