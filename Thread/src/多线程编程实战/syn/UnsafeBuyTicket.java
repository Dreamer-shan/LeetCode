package 多线程编程实战.syn;

/**
 * @author Shan
 * @Description 不安全的买票
 * @create 2021-02-07 21:02
 */
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();
        new Thread(station, "我").start();
        new Thread(station, "你").start();
        new Thread(station, "黄牛").start();
    }
}

class BuyTicket implements Runnable{
    private int ticket = 10;
    private boolean flag = true; // 外部停止方式
    @Override
    public void run() {
        while (flag){
            try {
                buy();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private synchronized void buy() throws InterruptedException {
        // 判断是否有票
        if (ticket <= 0){
            return;
        }

        // 买票
        System.out.println(Thread.currentThread().getName()+"拿到第 "+ticket--+" 张票");
    }
}
