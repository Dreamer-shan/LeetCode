package 有序数组的平方;

import java.lang.reflect.Array;
import java.util.Arrays;

class Solution {
    // 简单版 算出平方后再排序
    public static int[] sortedSquares1(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0; i < A.length; i++) {
            ans[i] = A[i]*A[i];
        }
        Arrays.sort(ans);  //直接 return Arrays.sort(ans)会报错
        return ans;
    }

    // 双指针版 利用题目非递减这一点 [-4,0, 1,2,3] 结果大的放到后面
    public static int[] sortedSquares2(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n -1; i <= j;) {
            if (A[i] * A[i] > A[j]* A[j]){
                ans[pos] = A[i] * A[i];
                i++;
            }
            else {
                ans[pos] = A[j] * A[j];
                j--;
            }
            pos--;
        }
        return ans;
    }



    public static void main(String[] args) {
        int[] a = {-4,0, 1,2,3};
        int[] ints = sortedSquares1(a);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}