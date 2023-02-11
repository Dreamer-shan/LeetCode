package demo;

/**
 * @author Shan
 * @Description 继承Thread类实现多线程
 * @create 2021-02-08 15:07
 */
public class demo01 {
    public static void main(String[] args) {
        Thread t1 = new Thread1("a");
        Thread t2 = new Thread1("b");
        t1.start();
        t2.start();
    }
}

class Thread1 extends Thread{
    private String name;
    public Thread1(String name){
        this.name = name;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
