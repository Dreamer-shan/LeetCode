package 多线程编程实战.state;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Shan
 * @Description 模拟网络延时：方法问题的发生性
 * @create 2021-02-07 17:19
 */
public class TestSleep2 implements Runnable{
    public static void main(String[] args) {
        Date startTime = new Date(System.currentTimeMillis());
        while (true){
            try {
                Thread.sleep(1000);
                System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
                startTime = new Date(System.currentTimeMillis());
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void tenDown() throws InterruptedException{
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num <= 0){
                break;
            }
        }
    }
    @Override
    public void run() {

    }
}
