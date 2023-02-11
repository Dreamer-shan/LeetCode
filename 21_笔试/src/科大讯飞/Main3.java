package 科大讯飞;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/28/19:53
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        for (int i = 0; i < n - 2; i++) {
            if (i != 0 && nums[i] == nums[i - 1]){
                ans[i]++;
            }
            if (nums[i] != nums[i+1] && nums[i] == nums[i+2]){
                swap(nums, i+1, i+2);
            }
        }
//        System.out.println(Arrays.toString(nums));
//        System.out.println(Arrays.toString(ans));
        int len = 0, l = 0, r = 1;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[l] == nums[r]){
//                r++;
//            }
//            int temp = r - l;
//            if (temp > len){
//                len = temp;
//            }
//            l = r;
//        }
        while (r < nums.length){
            if (nums[l] != nums[r]){
                int temp = r - l;
                if (temp > len){
                    len = temp;
                }
                l = r;
            }
            r++;

//            if (nums[l] != nums[r]) l = r;
        }
        System.out.println(len);

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
