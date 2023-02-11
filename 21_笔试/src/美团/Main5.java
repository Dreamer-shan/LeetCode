package 美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/04/16:13
 * @Description:
 */
public class Main5 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
//        int n = sc.nextInt();
        Random random = new Random(10);
        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
