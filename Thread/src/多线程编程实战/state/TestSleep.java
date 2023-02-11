package 多线程编程实战.state;

/**
 * @author Shan
 * @Description 模拟网络延时：方法问题的发生性
 * @create 2021-02-07 17:19
 */
public class TestSleep implements Runnable{
    private int ticket = 10;
    @Override
    public void run() {
        while (true){
            if (ticket<=0){
                break;
            }
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了第"+ticket-- +"张票");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep, "A").start();
        new Thread(testSleep, "B").start();
        new Thread(testSleep, "C").start();
    }
}
