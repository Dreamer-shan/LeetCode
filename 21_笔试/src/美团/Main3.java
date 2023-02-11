package 美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/04/16:13
 * @Description:
 */
public class Main3 {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 2) System.out.println(Math.pow(2, n));
        long ans = 6;
        long x = 4;
        long y = 2;
        for (int i = 4; i <= n; i++) {
            ans = (2 * ans - y) % 998244353;
            y = x;
            x = ans - y;
        }
        System.out.println(ans);
    }
}
