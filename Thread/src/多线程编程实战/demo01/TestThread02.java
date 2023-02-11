package 多线程编程实战.demo01;

/**
 * @author Shan
 * @Description 实现runnable接口
 * @create 2021-02-07 15:47
 */
public class TestThread02 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在看代码---" + i);
        }
    }

    public static void main(String[] args) {
        TestThread02 t2 = new TestThread02();
        Thread thread = new Thread(t2);
        thread.start();
        for (int i = 0; i < 20; i++) {
            System.out.println("我在学习多线程--" + i);
        }
    }
}
