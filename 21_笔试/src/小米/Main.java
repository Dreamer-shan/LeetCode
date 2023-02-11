package 小米;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/01/19:32
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] split = sc.nextLine().split(",");
        int m = Integer.valueOf(split[0].substring(2,3));
        int n = Integer.valueOf(split[1].substring(2,3));
        int[] num1 = new int[m + n];
        int[] num2 = new int[n];
        String[] str1 = sc.nextLine().split(",");
        for (int i = 0; i < m; i++) {
            num1[i] = Integer.valueOf(str1[i]);
        }
        String[] str2 = sc.nextLine().split(",");
        for (int i = 0; i < n; i++) {
            num2[i] = Integer.valueOf(str2[i]);
        }
//        System.out.println(Arrays.toString(num1));
//        System.out.println(Arrays.toString(num2));
        merge(num1, num2, m - 1, n - 1);
        for (int i = 0; i < m + n - 1; i++) {
            System.out.print(num1[i] + " ");
        }
        System.out.print(num1[m+n-1]);
    }

    public static void merge(int[] nums1, int[] nums2, int m, int n){
        int index = m + n + 1;
        while (m >= 0 && n >= 0){
            if (nums1[m] > nums2[n]){
                nums1[index--] = nums1[m--];
            }else {
                nums1[index--] = nums2[n--];
            }
        }

        while (m >= 0) nums1[index--] = nums1[m--];
        while (n >= 0) nums1[index--] = nums2[n--];
    }
}
