package 螺旋矩阵2;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/24/11:12
 * @Description:59题
 */
class Solution {
    public int[][] generateMatrix(int n) {
        int num = 1, end = n * n;
        int t = 0, b = n -1, l = 0, r = n - 1;
        int[][] f = new int[n][n];
        while (num <= end){
            // 左到右
            for (int i = l; i <= r; i++) {
                f[t][i] = num++;
            }
            t++;
            // 上到下
            for (int i = t; i <= b; i++) {
                f[i][r] = num++;
            }
            r--;
            // 右到左
            for (int i = r; i >= l; i--) {
                f[b][i] = num++;
            }
            b--;
            // 下到上
            for (int i = b; i >= t; i--) {
                f[i][l] = num++;
            }
            l++;
        }
        return f;
    }
}