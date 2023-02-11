package 转置矩阵_867;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/22/13:25
 * @Description:
 */
class Solution {
    public static int[][] transpose(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] target = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                target[i][j] = A[j][i];
            }
        }
        return target;
    }

    public int[][] transpose1(int[][] A) {
        int row = A.length;
        int col = A[0].length;
        int[][] ans = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                ans[i][j] = A[j][i];
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[][] a = {{1,2,3},{4,5,6}};
        int[][] transpose = transpose(a);
    }
}
