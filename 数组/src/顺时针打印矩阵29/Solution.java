package 顺时针打印矩阵29;

/**
 * @author Shan
 * @Description
 * @create 2021-01-30 11:07
 */
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0)    return new int[0];
        int index = 0, u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        int[] res = new int[(d+1) * (r + 1)];
        while (true){
            for (int i = l; i <= r; i++) {
                res[index++] = matrix[u][i];

            }
            if (++u > d)    break;
            for (int i = u; i <= d; i++) {
                res[index++] = matrix[i][r];

            }
            if (--r < l)    break;
            for (int i = r; i >= l; i--) {
                res[index++] = matrix[d][i];
            }
            if (--d < u)    break;
            for (int i = d; i >= u; i--) {
                res[index++] = matrix[i][l];
            }
            if (++l > r)    break;
        }
        return res;
    }
}
