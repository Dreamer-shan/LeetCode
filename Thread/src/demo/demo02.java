package demo;

/**
 * @author Shan
 * @Description 实现Runnable接口实现多线程
 * @create 2021-02-08 15:25
 */
public class demo02 {
    public static void main(String[] args) {
        new Thread(new Thread2("A")).start();
        new Thread(new Thread2("B")).start();
    }
}

class Thread2 implements Runnable{
    private String name;

    public Thread2(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + "运行  :  " + i);
        }
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


