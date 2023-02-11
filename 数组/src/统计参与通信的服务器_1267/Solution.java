package 统计参与通信的服务器_1267;

/**
 * @author Shan
 * @Description
 * @create 2020-11-26 10:41
 */
class Solution {
    public int countServers2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // 记录每行每列有多少个服务器
        int[] count_row = new int[m];
        int[] count_col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    count_row[i]++;
                    count_col[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 该位置没有服务器，跳过，不计数
                if (grid[i][j] == 0)    continue;
                // 该行该列的服务器数量只有一个（即其自身）则它无法与任何其他服务器通信，跳过，不计数
                if (count_row[i] == 1 && count_col[j] == 1) continue;
                // 其余的都可以通信
                count++;
            }
        }
        return count;
    }

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] count_row = new int[m];
        int[] count_col = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1){
                    count_row[i]++;
                    count_col[j]++;
                }
            }
        }
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && (count_row[i] > 1 || count_col[j] > 1)){
                    count++;
                }
            }
        }
        return count;
    }
}