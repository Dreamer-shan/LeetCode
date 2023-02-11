package demo;

/**
 * @author Shan
 * @Description 不加join方法  主线程比子线程早结束
 * @create 2021-02-08 15:37
 */
public class demo03 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName()+"主线程运行开始!");
        Thread3 t1 = new Thread3("A");
        Thread3 t2 = new Thread3("B");
        t1.start();
        t2.start();
        System.out.println(Thread.currentThread().getName()+ "主线程运行结束!");
    }
}

class Thread3 extends Thread {
    private String name;

    public Thread3(String name) {
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
    }
}