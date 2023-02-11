package 搜索二维矩阵_74;

/**
 * @author Shan
 * @Description 74题
 * @create 2020-11-26 13:16
 */
class Solution {

    public static boolean searchMatrix(int[][] matrix, int target) {
        // 特殊情况
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        int min = matrix[0][0], max = matrix[m-1][n-1];
        if (target < min || target > max)   return false;
        // 记录target在哪一行
        int row = 0;
        // 第一列
        for (int i = 0; i < m; i++) {
            if (target == matrix[i][0]){
                return true;
            }
        }

        for (int i = 0; i < m-1; i++) {
            if (target > matrix[i][0] && target < matrix[i + 1][0]){
                row = i;
            }
        }

        // 最后一列
        for (int j = 0; j < n; j++) {
            if (matrix[m-1][j] == target){
                return true;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[row][j] == target){
                return true;
            }
        }
        return false;
    }

    // 从左下角开始，如果target > matrix[i][j],则目标值在下一列 j++
    // 如果target < matrix[i][j],则目标值在上一行 i--
    // 相等则直接return
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length){
            if (target > matrix[i][j]){
                j++;
            }else if (target < matrix[i][j]){
                i--;
            }else {
                return true;
            }
        }
        return false;
    }

    public static boolean searchMatrix3(int[][] matrix, int target) {
        int m = matrix.length;
        if (m==0) return false;
        int n = matrix[0].length;
        int left = 0, right = n * m -1;
        int mid_idx, mid_element;
        while (left <= right){
            mid_idx = (left + right) / 2;
            mid_element = matrix[mid_idx / n][mid_idx % n];
            if (target == mid_element)  return true;
            else {
                if (target > mid_element)   left = mid_idx + 1;
                else right = mid_idx - 1;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[][] p = {{1,3,5,7},{10,11,16,20},{23,30,34,50}};
        boolean b = searchMatrix3(p, 13);
        System.out.println(b);
    }
}