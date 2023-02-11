package 排序.Top问题;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/16/21:28
 * @Description:一般有两种 快排和堆排
 */
public class Solution {
    public static void main(String[] args) {
//        int[] arr = {1, 5, 6, 1, 4, 7, 5, 6, 2, 1, 4, 5, 6, 3};
        int[] arr = {1,3,5,2};
        int[] ints = topkSmall(arr, 3);
        System.out.println(Arrays.toString(ints));
//        quickSort(arr, 0, arr.length - 1);
//        int[] ints = topkSmall(arr, 5);
//        int[] ints1 = topkLarge(arr, 5);
//        System.out.println(Arrays.toString(ints1));
//        System.out.println(topkSmall1(arr, 5));
//        System.out.println(Arrays.toString(ints));
//        System.out.println(Arrays.toString(arr));
    }

    
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    public static int getIndex(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= temp) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp) low++;
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    // //topK切分 这个位置左边是k个比这个位置上的数更小的数，右边是n-k个比该位置上的数大的数
    public static void topkSplit(int[] arr, int low, int high, int k) {
        if (low < high) {
            int index = getIndex(arr, low, high);
            if (index == k) return;
            else if (index < k) topkSplit(arr, index + 1, high, k);
            else topkSplit(arr, low, index - 1, k);
        }
    }
    // 前k小的数
    public static int[] topkSmall(int[] arr, int k) {
        topkSplit(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
    // 第k小的数，返回k-1的位置
    public static int topkSmall1(int[] arr, int k) {
        topkSplit(arr, 0, arr.length - 1, k);
        return arr[k - 1];
    }

    public static int[] topkLarge(int[] arr, int k) {
//        topkSplit(arr, 0, arr.length - 1,  k);
        topkSplit(arr, 0, arr.length - 1, arr.length - k);
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }
}
