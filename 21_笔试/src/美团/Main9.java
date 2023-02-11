package 美团;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/04/19:03
 * @Description:
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int n = strs.length;
        String[] arr = new String[n];
        for (int i = 0; i < strs.length; i++) {
            arr[i] = strs[i];
        }
//        System.out.println(Arrays.toString(arr));
        System.out.println(n);

        int m = sc.nextInt();
        int total = sc.nextInt();
//        System.out.println(n - m + 1);
        total = Math.min(total, n - m + 1);
        for (int i = 0; i < total; i++) {
            if (i == total - 1 || (i % 19 == 0 && i != 0)){
                System.out.println(arr[m-1]);
            }else {
                System.out.print(arr[m-1] + ";");
            }
            m++;
        }
    }
}
