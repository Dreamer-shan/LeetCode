package 网易;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/21/16:08
 * @Description:
 */
public class Solution1 {
    public int minSailCost (int[][] input) {
        // write code here
        if (input.length == 0 || input[0].length == 0)   return -1;
        int n = input.length, m = input[0].length;
        if (input[n-1][m-1] == 2 || input[0][0] == 2)   return  -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0){
                    input[i][j] = 0;
                    continue;
                }
                if (input[i][j] == 2 )  input[i][j] = -1;
                else if (input[i][j] == 0)  input[i][j] = 2;
            }
        }
        for (int i = 1; i < n; i++) {
            if (input[i][0] != -1 && input[i-1][0] != -1) input[i][0] += input[i-1][0];
        }
        for (int i = 1; i < m; i++) {
            if (input[0][i] != -1 && input[0][i-1] != -1) input[0][i] += input[0][i-1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (input[i][j] != -1){
                    if (input[i-1][j] == -1 && input[i][j-1] == -1) input[i][j] = -1;
                    else if (input[i - 1][j] == -1) input[i][j] += input[i][j - 1];
                    else if (input[i][j - 1] == -1) input[i][j] += input[i-1][j];
                    else input[i][j] += Math.min(input[i][j-1], input[i-1][j]);
                }
            }
        }
        return input[n-1][m-1];
    }
}
