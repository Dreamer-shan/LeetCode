package 多线程编程实战.state;

/**
 * @author Shan
 * @Description 测试join 可以想象为插队
 * 开始时两个线程交替执行，main线程到50时，执行join，vip线程开始执行
 * vip线程全部执行完后，在执行main线程
 * @create 2021-02-07 19:57
 */
public class TestJoin implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 300; i++) {
            System.out.println("vip线程来了 "+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // 启动线程
        TestJoin testJoin = new TestJoin();
        Thread thread = new Thread(testJoin);
        thread.start();

        // 主线程
        for (int i = 0; i < 200; i++) {
            if (i == 50){
                thread.join();
            }
            System.out.println("main " + i);
        }
    }
}
