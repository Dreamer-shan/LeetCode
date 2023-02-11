package 贝壳;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/03/19:07
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0, max = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] > m){
                i -= k;
            }
            sum += arr[i];
            if (max > sum)  max = sum;
        }
        System.out.println(sum);
//        System.out.println(33+15+10+8+5);
    }
}
