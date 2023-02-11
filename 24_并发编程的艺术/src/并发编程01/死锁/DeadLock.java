package 并发编程01.死锁;

public class DeadLock {
    private static Object A = new Object();
    private static Object B = new Object();

    public static void main(String[] args) {
        new DeadLock().deadLock();
    }
    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.currentThread().sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("尝试获取B的锁");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("尝试获取A的锁");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
