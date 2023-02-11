package 等差数列划分413;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/08/11:16
 * @Description:
 */
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        if (n < 3) return 0;
        int count = 0;
        for (int i = 0; i < n - 2; i++) {
            int d = A[i + 1] - A[i];
            for (int j = i + 2; j < n; j++) {
                if (A[j] - A[j - 1] == d) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public int numberOfArithmeticSlices2(int[] A) {
        if (A.length < 3) return 0;
        int n = A.length;
        int[] dp = new int[n];
        int sum = 0;
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
                sum += dp[i];
            }
        }
        return sum;
    }

}


