package 三个数的最大乘积_628;

import java.util.Arrays;

/**
 * @author Shan
 * @Description
 * @create 2020-11-25 13:27
 */

/*
升序排列后
如果全是正数，取最后三个数的乘积
如果有负数，取前两个数和最后一个数的乘积
 */
class Solution {
    public static int maximumProduct1(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[n-1]*nums[n-2]*nums[n-3], nums[n-1]*nums[1]*nums[0]);
    }


    public static int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num >= max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if(num >= max2){
                max3 = max2;
                max2 = num;
            }else if (num >= max3){
                max3 = num;
            }
            if (num <= min1){
                min2 = min1;
                min1 = num;
            }else if (num <= min2){
                min2 = num;
            }
        }
        return Math.max(min1*min2*max1, max1*max2*max3);
    }

    public static void main(String[] args) {
        System.out.println("aaa");
    }
}