package 多线程编程实战.DeadLock;

/**
 * @author Shan
 * @Description
 * @create 2021-02-08 10:50
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "A");
        Makeup g2 = new Makeup(1, "B");
        g1.start();
        g2.start();
    }
}


class Lipstick{

}

class Mirror{

}

class Makeup extends  Thread{
    // 需要的资源只有一份，用static来保证只有一份
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    int choice; // 选择
    String girlName;    // 使用化妆品的人

    public Makeup(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }

    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void makeup() throws InterruptedException {
        if (choice == 0){
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
                Thread.sleep(1000);
                synchronized (mirror){
                    System.out.println(this.girlName+"获得镜子的锁");
                }
            }

        }else {
            synchronized (mirror){
                System.out.println(this.girlName+"获得镜子的锁");
                Thread.sleep(1000);

            }
            synchronized (lipstick){
                System.out.println(this.girlName+"获得口红的锁");
            }
        }
    }
}