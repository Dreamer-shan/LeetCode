package Zoom;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/28/17:33
 * @Description:
 */
import java.util.*;


//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     *
//     * @param nums int整型一维数组
//     * @param windowSize int整型 滑动窗口大小
//     * @param step int整型 每次移动step个数字
//     * @return int整型一维数组
//     */
//    public int[] slideWindow (int[] nums, int windowSize, int step) {
//        // write code here
//
//    }
//}


import java.util.*;


public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param nums int整型一维数组
     * @return int整型
     */
    public int find132Pattern (int[] nums) {
        // write code here
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (i < j && j < k && nums[i] < nums[k] && nums[k] < nums[j]){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int[] slideWindow (int[] nums, int windowSize, int step) {
        // write code here
        if (nums.length == 0 || nums == null)   return new int[0];
        int n = nums.length;
        int left = 0, right = left + windowSize - 1;
        int max = Integer.MIN_VALUE;
        int j = 0;
        int[] temp = new int[n+1];
        while (right < n){
            for (int i = left; i <= right; i++){
                if (nums[i] > max){
                    max = nums[i];
                }
            }
            left += step;

            if (right < n - 1){
                right += step;
            }else {
                right += 0;
            }
            System.out.println(right);
            temp[j] = max;
            max = Integer.MIN_VALUE;
            j++;
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] window = slideWindow(arr, 3, 1);
        System.out.println(Arrays.toString(window));
    }
}