package 多线程编程实战.state;

/**
 * @author Shan
 * @Description
 * @create 2021-02-07 20:48
 */
public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true); // 默认false是表示用户线程
        // 守护线程启动
        thread.start();

        // 用户线程启动
        new Thread(you).start();

    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你一生都活着");
        }
        System.out.println("goodbye world");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("上帝一直活着");
        }
    }
}
