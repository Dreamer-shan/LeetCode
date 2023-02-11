package demo;

/**
 * @author Shan
 * @Description 3线程打印ABC
 * @create 2021-02-08 15:52
 */
public class demo05 {
    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Thread5 pa = new Thread5("A", c, a);
        Thread5 pb = new Thread5("B", a, b);
        Thread5 pc = new Thread5("C", b, c);
        new Thread(pa).start();
        new Thread(pb).start();
        new Thread(pc).start();
    }
}

class Thread5 implements Runnable {
    private String name;
    private Object prev;   // 前一个对象
    private Object self;   // 自身对象

    public Thread5(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev){
                synchronized (self){
                    System.out.print(name);
                    count--;

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
