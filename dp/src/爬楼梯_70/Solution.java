package 爬楼梯_70;

import java.util.Arrays;

/**
 * @author Shan
 * @Description
 * @create 2020-12-21 11:32
 */
class Solution {
    // 递归
    public int climbStairs1(int n) {
        if (n <= 2)
            return n;
        return climbStairs1(n-1) + climbStairs1(n-2);
    }
    // 尾递归
    public static int climbStairs2(int n) {
        return Fibonacci(n, 1, 1);
    }

//    int fiboTail(int n, int acc, int cal)
//        //acc充当收集器的左右，收集上一次运行栈的返回值，因为之后栈空间会被回收
//        //cal是每一次递归的计算
//    {
//        if (n == 1) return acc;
//        if (n == 2) return cal;
//        return fiboTail(n - 1, cal, acc+cal);
//    }

    public static int Fibonacci(int n, int a, int b) {
        if (n <= 1)
            return b;
        return Fibonacci(n - 1, b, a + b);

    }


    public int climbStairs3(int n) {
        if (n <= 2) {
            return n;
        }
        /*
            初始化 dp数组，因为要保存0级台阶，所以长度为 n+1
            dp[i]表示 第i级台阶 一共有 dp[i] 种到达情况
         */
        int[] dp = new int[n + 1];

        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            /*
                到达当前台阶的情况有如下两种：
                    1、上一级台阶 跨一步
                    2、上一级的上一级的台阶 跨两步
             */
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairs4(int n) {
        if (n <= 2) return n;
        int first = 1, second = 2, sum = 0;
        for (int i = 3; i <= n; ++i) {
            sum = first + second;
            first = second;
            second = sum;
        }
        return sum;
    }
}

