/**
 * @author Shan
 * @Description
 * @create 2021-09-06 17:32
 */
public class Test7 {
    public static String obj1 = "a";
    public static String obj2 = "b";

    public static void main(String[] args) {
        new Thread(new LockA()).start();
        new Thread(new LockB()).start();
    }
}

class LockA implements Runnable {
    public void run() {

        synchronized (Test7.obj1) {
            System.out.println(" LockA 锁住 obj1");
            try {
                Thread.sleep(3000); // 此处等待是给B能锁住机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Test7.obj2) {
                System.out.println(" LockA 锁住 obj2");
                try {
                    Thread.sleep(60 * 1000); // 为测试，占用了就不放
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class LockB implements Runnable {
    public void run() {

        synchronized (Test7.obj2) {
            System.out.println(" LockB 锁住 obj1");
            try {
                Thread.sleep(3000); // 此处等待是给B能锁住机会
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (Test7.obj1) {
                System.out.println(" LockB 锁住 obj2");
                try {
                    Thread.sleep(60 * 1000); // 为测试，占用了就不放
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
