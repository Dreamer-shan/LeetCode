package 矩阵置零_73;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Shan
 * @Description
 * @create 2020-11-24 23:38
 */
class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length, col = matrix[0].length;
        boolean row0_flag = false, col0_flag = false;

        // 判断第1行有没有0
        for (int j = 0; j < col; j++) {
            if (matrix[0][j] == 0){
                row0_flag = true;
                break;
            }
        }
        // 判断第1列有没有0
        for (int i = 0; i < row; i++) {
            if (matrix[i][0] == 0){
                col0_flag=true;
                break;
            }
        }

        // 把第一行第一列作为标志位
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][j] == 0){
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        // 置0
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix[i][0] == 0 || matrix[0][j]==0){
                    matrix[i][j] = 0;
                }
            }
        }

        // 处理第1行和第1列
        if (row0_flag){
            for (int j = 0; j < col; j++) {
                matrix[0][j] = 0;
            }
        }
        if (col0_flag){
            for (int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}