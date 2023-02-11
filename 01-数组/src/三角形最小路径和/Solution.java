package 三角形最小路径和;

import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/23/15:56
 * @Description:动态规划
 * 和面试官进行沟通，可以询问「是否有空间复杂度限制」「是否可以修改原数组」等问题，给出符合条件的算法。
 */

class Solution {
    // 从上至下，f中最后一行的最小值就是答案
    public int minimumTotal1(List<List<Integer>> triangle) {
        // 从第0行开始计数， 第i行有i+1个数字

        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            //每行最左端
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);

            // 每行中间
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }

            //每行最右端
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }

        // f[n-1][0] 到 f[n-1][n-1] 中的最小值
        // 最后一行最左端
        int minTotal = f[n - 1][0];

        // f[n-1][i] 最后一行最右端
        for (int i = 1; i < n; i++) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }

    public int minimumTotal2(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp[i][j] 表示从点 (i, j) 到底边的最小路径和。  数组开[n][n]大小的话 dp[i + 1][j]会越界
        int[][] dp = new int[n + 1][n + 1];
        // 从三角形的最后一行开始递推。
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    // 计算 dp[i][j] 时，只用到了下一行的 dp[i + 1][j] 和 dp[i + 1][j + 1]

    public static int minimumTotal3(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    // 改变原数组的值  从倒数第二行开始递归  此方法不用新开数组
    public int minimumTotal4(List<List<Integer>> triangle) {
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                triangle.get(i).set(
                        j,
                        triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1))
                );
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {
        System.out.println("aa");
    }
}