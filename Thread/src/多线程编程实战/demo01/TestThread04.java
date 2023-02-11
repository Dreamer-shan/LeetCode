package 多线程编程实战.demo01;

/**
 * @author Shan
 * @Description 模拟龟兔赛跑
 * @create 2021-02-07 16:00
 */
public class TestThread04 implements Runnable{
    private String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            // 模拟兔子休息
            if (Thread.currentThread().getName().equals("兔子")&& i % 10 == 1){
                try {
                    Thread.sleep(20);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName() + " 跑了->" + i + "步");
        }
    }
    private boolean gameOver(int steps){
        if (winner != null){
            return true;
        }
        if (steps >= 100){
            winner = Thread.currentThread().getName();
            System.out.println("winner is "+winner);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TestThread04 testThread04 = new TestThread04();
        new Thread(testThread04,"兔子").start();
        new Thread(testThread04, "乌龟").start();
    }
}
