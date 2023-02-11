package 对角线遍历_498;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/27/11:49
 * @Description:
 */
//class Solution {
//    public static int[] findDiagonalOrder(int[][] matrix) {
//        Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
//        int row = matrix.length;
//        if (row == 0)   return new int[0];
//        int col = matrix[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (!map.containsKey(i+j))
//                    map.put(i+j, new LinkedList<>());
//                if ((i+j) % 2 ==0)
//                    map.get(i+j).addFirst(matrix[i][j]);
//                if ((i+j) % 2== 1)
//                    map.get(i+j).addLast(matrix[i][j]);
//            }
//        }
//        int[] ans = new int[row*col];
//        int index = 0;
//        for (Integer key : map.keySet()) {
//            List<Integer> list = map.get(key);
//            for (int i = 0; i < list.size(); i++) {
//                ans[index++] = list.get(i);
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        int[][] p = {{1,2,3},{4,5,6},{7,8,9}};
//        int[] ans = findDiagonalOrder(p);
//        for (int an : ans) {
//            System.out.print(an + " ");
//        }
//    }
//}

class Solution {
    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int row_length = matrix.length;
        int col_length = matrix[0].length;
        int[] ans = new int[row_length * col_length];
        int count = row_length + col_length - 1;
        int m = 0, n = 0, index = 0;
        for (int i = 0; i < count; i++) {
            if (i % 2 == 0) {
                while (m >= 0 && n < col_length) {
                    ans[index++] = matrix[m][n];
                    m--;
                    n++;
                }
                if (n < col_length) {
                    m++;
                } else {
                    m += 2;
                    n--;
                }
            } else {
                while (n >= 0 && m < row_length) {
                    ans[index++] = matrix[m][n];
                    m++;
                    n--;
                }
                if (m < row_length) {
                    n++;
                } else {
                    m--;
                    n += 2;
                }
            }
        }
        return ans;
    }
}