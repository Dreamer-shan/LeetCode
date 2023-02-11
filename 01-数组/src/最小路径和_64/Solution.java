package 最小路径和_64;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/30/10:20
 * @Description:
 */
class Solution {
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)    return 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        f[0][0] = grid[0][0];
        // 第一行
        for (int j = 1; j < n; j++) {
            f[0][j] = f[0][j - 1] + grid[0][j];
        }
        // 第一列
        for (int i = 1; i < m; i++) {
            f[i][0] = f[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                f[i][j] = Math.min(f[i-1][j], f[i][j-1]) + grid[i][j];
            }
        }
        return f[m-1][n-1];
    }

    // 我们看到二维数组dp和二维数组grid的长和宽都是一样的，没必要再申请一个dp数组，完全可以使用grid
    public int minPathSum2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;
                if (i == 0) {
                    //第一行只能从左边走过来
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    //第一列只能从上面走下来
                    grid[i][j] += grid[i - 1][j];
                } else {
                    //递推公式，取从上面走下来和从左边走过来的最小值+当前坐标的值
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[m - 1][n - 1];
    }

}
