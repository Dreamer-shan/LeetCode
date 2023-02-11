package vivo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/26/19:42
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(combinationSum4(nums,4));
//        System.out.println(combinationSum4(nums,1));
//        System.out.println(combinationSum4(nums,2));
//        System.out.println(combinationSum4(nums,3));
    }

    public static int combinationSum4(int[] nums, int target) {
        if (target == 0)    return 0;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }
}
