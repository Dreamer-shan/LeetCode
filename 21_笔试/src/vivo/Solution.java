package vivo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/22/15:29
 * @Description:
 */
public class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 返回最多能挑选出多少个武将，使得两两之间均存在碾压关系
     * @param heroes int整型二维数组 武将属性值列表
     * @return int整型
     */
    public static int maxRollingHeroes () {
        // write code here

        int[][] heroes = new int[][]{{60,35,20},{30,40,30},{40,50,40},{50,60,50},{55,45,60}};
        if (heroes.length == 0) return 0;
        int len = heroes[0].length;
        Arrays.sort(heroes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < len; i++) {
                    if (o1[i] != o2[i]) return o1[i] - o2[i];
                }
                return 1;
            }
        });
        System.out.println(Arrays.deepToString(heroes));
        int max = 0;
        int[] dp = new int[heroes.length];
        for (int i = 0; i < heroes.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                boolean flag = true;
                for (int k = 1; k < len; k++) {
                    if (heroes[i][k] < heroes[j][k]){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    if (dp[j] + 1 > dp[i])  dp[i] = dp[j]+1;
                }
            }
            if (dp[i] > max)    max = dp[i];
        }
        System.out.println(max);
        return max;
    }

    public static int maxRollingHeroes2() {
        // write code here
        int[][] heroes = new int[][]{{60,35,20},{30,40,30},{40,50,40},{50,60,50},{55,45,60}};
        if (heroes.length == 0) return 0;
        int n = heroes.length;
        int k = heroes[0].length;
        Arrays.sort(heroes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                for (int i = 0; i < k; i++) {
                    if (o1[i] != o2[i]) return o1[i] - o2[i];
                }
                return 1;
            }
        });
        int max = 0;
        int[] dp = new int[heroes.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int v = 0; v < k; v++) {
                    if (heroes[i][v] <= heroes[j][v]){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    dp[i] = Math.max(dp[i],dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
        return max;
    }

    public static int fun(int[] userId, float[] cost, float[] conversion, float avg_cost){

        int n = userId.length;
        List<float[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new float[]{i, cost[i] / conversion[i]});
        }
        for (float[] floats : list) {
            System.out.println(Arrays.toString(floats));
        }
        return 0;
    }

    public static void main(String[] args) {
//        maxRollingHeroes();
//        List<int[]> list = new ArrayList<>();
//        int[][] heroes = new int[][]{{60,35,20},{30,40,30},{40,50,40},{50,60,50},{55,45,60}};
//        for (int[] hero : heroes) {
//            list.add(hero);
//        }
//        for (int[] ints : list) {
//            System.out.println(Arrays.toString(ints));
//        }
        float[] cost = {2,3,1,4,2};
        int[] userId = {1,2,3,4,5};
        float[] conversion = {0.2f,0.1f,0.2f,0.1f,0.4f};
        fun(userId, cost, conversion, 10);
    }
}

//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     *
//     * @param n int整型 未来空闲工作日
//     * @return int整型
//     */
//    ThreadPoolExecutor
//    public int workSchedule (int n) {
//        // write code here
//        if (n <= 3) return n;
//        int count = 0;
//        for (int i = 0; i*i <= n; i++) {
//            if (i * 1 == n){
//                count++;
//                continue;
//            }
//            for(int j = 0; i * 1 + j * 2 <= n; j++){
//                if (i * 1 + j * 2 == n){
//                    count++;
//                    continue;
//                }
//                for(int k = 0; i * 1 + j * 2 + k * 4 <= n; k++){
//                    if (i * 1 + j * 2 == n )
//                }
//            }
//        }
//
//    }
//}
