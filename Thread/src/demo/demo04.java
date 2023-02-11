package demo;

/**
 * @author Shan
 * @Description 加join方法  主线程比子线程晚结束
 * @create 2021-02-08 15:42
 */
public class demo04 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread4 t1 = new Thread4("A");
        Thread4 t2 = new Thread4("B");
        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
    }
}

class Thread4 extends Thread {
    private String name;

    public Thread4(String name) {
        super(name);
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " 线程运行开始!");
        for (int i = 0; i < 5; i++) {
            System.out.println("子线程" + name + "运行 : " + i);
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + " 线程运行结束!");
    }
}
