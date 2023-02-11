package lock8;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/07/12/19:38
 * @Description:
 */
public class Main {
    byte[] buffer = new byte[new Random().nextInt(1024 * 200)];
    public static void main(String[] args) {
        ArrayList<Main> list = new ArrayList<>();
        while (true){
            list.add(new Main());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
