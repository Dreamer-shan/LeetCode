package 编程实例;

/**
 * @author Shan
 * @Description
 * @create 2021-02-08 20:51
 */
public class demo01 {
    public static void main(String[] args) {
        Station station1 = new Station("窗口1");
        Station station2 = new Station("窗口2");
        Station station3 = new Station("窗口3");
        station1.start();
        station2.start();
        station3.start();
    }
}

class Station extends Thread{
    // 为了保持票数的一致，票数要静态
    static int ticket = 20;
    // 创建一个静态对象
    static Object ob = "aa";
    public Station(String name) {
        super(name);    // 给线程名字赋值
    }


    @Override
    public void run() {
        while (ticket > 0){
            synchronized (ob){
                if (ticket > 0){
                    System.out.println(Thread.currentThread().getName()+ "卖出了第" + ticket + "张票");
                    ticket--;
                }else {
                    System.out.println("票卖完了");
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
