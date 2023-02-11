package 富途;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/12/17:33
 * @Description:
 */
public class Solution {
    /**
     * return the maxfifference
     * @param arr int整型一维数组 the array
     * @return int整型
     */
    public int maxDistance (int[] arr) {
        // write code here
        Arrays.sort(arr);
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            max = Math.max(max, arr[i] - arr[i - 1]);
        }
        return max;
    }

    public int solve (String nums) {
        // write code here
//        if (nums == null || nums.length() == 0) return 0;
//        nums = nums.trim();
        int n = nums.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (nums.charAt(i - 1) != '0'){
                dp[i] += dp[i - 1];
            }
            if (i > 1 && nums.charAt(i - 2) != '0' && (nums.charAt(i - 2) - '0') * 10 + (nums.charAt(i - 1) - '0') <= 26){
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}