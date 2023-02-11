package 矩阵置零;

import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/24/16:44
 * @Description:73题
 */
class Solution {
    public void setZeroes1(int[][] matrix) {
        Set<Integer> row_zero = new HashSet<>();
        Set<Integer> col_zero = new HashSet<>();
        int m = matrix.length,  n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0){
                    row_zero.add(i);
                    col_zero.add(j);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (row_zero.contains(i) || col_zero.contains(j)){
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean row_flag = false, col_flag = false;
        int row = matrix.length,  col = matrix[0].length;

        for (int i = 0; i < col; i++) {
            if (matrix[0][i] == 0){
                row_flag = true;
                break;
            }
        }

        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0){
                col_flag = true;
                break;
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (row_flag){
            for (int i = 0; i < col; i++) {
                matrix[0][i] = 0;
            }
        }
        if (col_flag){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}