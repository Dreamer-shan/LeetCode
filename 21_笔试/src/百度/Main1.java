package 百度;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/28/20:32
 * @Description:
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        for (int i = 0; i < n; i++) {
            price[i] = arr[i][0] + arr[i][1] * i;
        }
        int sum = 0;
//        System.out.println(Arrays.toString(price));
        for (int i = 0; i < n; i++) {
            if (i % 2 == 1){
                sum += price[i];
                price[n - i] = 0;
            }else{
                sum += price[i];
            }
        }
        System.out.println(sum);
//        System.out.println(Arrays.deepToString(arr));

    }
}
