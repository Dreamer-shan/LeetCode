/**
 * @author Shan
 * @Description
 * @create 2021-07-26 14:02
 */
public class Test {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    System.out.println("线程1拿到了A的锁");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("线程1拿到了B的锁");
                    }
                }


            }
        },"1").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    System.out.println("线程2拿到了B的锁");
                    synchronized (A){
                        System.out.println("线程2拿到了A的锁");
                    }
                }

            }
        },"2").start();
    }
}
