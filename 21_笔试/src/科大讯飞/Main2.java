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
public class Main2 {
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
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(ans));
//        int len = Integer.MIN_VALUE;
        int temp = 1;
        List<int[]> list = new ArrayList<>();
        list.add(nums);
        for (int[] ints : list) {
            System.out.println(ints);
        }
        int len = 0;
        for (int i = 0; i < list.size(); i++) {
            int index = list.indexOf(list.get(0)[i]);
            int index2 = list.lastIndexOf(list.get(0)[i]);
            System.out.println(index + " " + index2);

            if (index2 - index > len){
                len = index2 - index;
            }
        }
        System.out.println(len);
//        for (int i = 0; i < nums.length - 1; i++) {
//            if (nums[i] == nums[i + 1]){
//                temp++;
//                if (temp > len){
//                    len = temp;
//                }
//            }
//        }
//        System.out.println(len);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
