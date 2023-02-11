package 多线程编程实战.demo01;

/**
 * @author Shan
 * @Description 售票
 * @create 2021-02-07 15:53
 */
public class TestThread03 implements Runnable{
    private int tickets = 10;
    @Override
    public void run() {
        while (tickets != 0){
            if (tickets <= 0){
                break;
            }
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "拿到了第 " + tickets-- +" 张票");
        }
    }

    public static void main(String[] args) {
        TestThread03 testThread03 = new TestThread03();
        new Thread(testThread03,"小明").start();
        new Thread(testThread03,"老师").start();
        new Thread(testThread03,"黄牛").start();
    }
}
