package 构建乘积数组66;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/03/08/21:09
 * @Description:
 */
public class Solution {
    public static int[] constructArr(int[] a) {
        if (a == null || a.length == 0) return a;
        int len = a.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] arr = constructArr(a);
        System.out.println(Arrays.toString(arr));
    }
}