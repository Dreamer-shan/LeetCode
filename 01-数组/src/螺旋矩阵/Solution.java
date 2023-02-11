package 螺旋矩阵;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/24/10:25
 * @Description: 54题
 */
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if (matrix.length == 0) return list;
        int u = 0, d = matrix.length - 1, l = 0, r = matrix[0].length - 1;
        while (true){
            // l to r
            for (int i = l; i <= r; i++) {
                list.add(matrix[u][i]);
            }
            if (++u > d)    break;

            // u to d
            for (int i = u; i <= d; i++) {
                list.add(matrix[i][r]);
            }
            if (--r < l)    break;


            for (int i = r; i >= l; i--) {
                list.add(matrix[d][i]);
            }
            if (--d < u)    break;

            for (int i = d; i >= u; i--) {
                list.add(matrix[i][l]);
            }
            if (++l > r)    break;
        }
        return list;
    }
}



