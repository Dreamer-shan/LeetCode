package 统计参与通信的服务器_1267;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/25/21:44
 * @Description:
 */

class Solution {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 记录每行每列的服务器数量
        int[] row = new int[m];
        int[] col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0)    continue;
                // 该行该列的服务器数量只有一个（即其自身）则它无法与任何其他服务器通信
                if (row[i] == 1 && col[j] == 1) continue;
                ans++;
            }
        }
        return ans;
    }
}