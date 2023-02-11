package 转置矩阵;

class Solution {
    public static int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] ans = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                ans[i][j] =A[j][i];  //ans[i][j] = A[j][i] 会超出索引
            }
        }
        return ans;
    }
}