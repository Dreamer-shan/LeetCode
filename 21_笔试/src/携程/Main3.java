package 携程;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/09/20:03
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String line = sc.next();
        int[] arr = new int[n + 1];
        int[][] nums = new int[m][2];
        for (int i = 0; i < m; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
        }
        arr[0] = 0;
        int num = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (c == '1') {
                num++;
                int max = arr[i];
                for (int j = 0; j < m; j++) {
                    if(nums[j][0] <= num && arr[i - nums[j][0] + 1] + nums[j][1] > max){
                        max = nums[j][1] + arr[i - nums[j][0] + 1];
                    }
                }
                arr[i + 1] = max;
            }else {
                num = 0;
                arr[i + 1] = arr[i];
            }
        }
        System.out.println(arr[n]);
    }
}
