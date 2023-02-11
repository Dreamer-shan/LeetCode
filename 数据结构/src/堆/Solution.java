package 堆;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/27/16:22
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {115,4,5,2,1,4,5,5,6};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        if (arr.length <= 1 || arr == null) return;
        int heapSize = arr.length;
        buildMaxHeap(heapSize, arr);
        for (int i = heapSize - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapSize--;
            heapify(arr, 0, heapSize);
        }
    }
    public static void buildMaxHeap(int heapSize, int[] arr){
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
    }

    private static void heapify(int[] arr, int i, int heapSize) {
        int l = 2 * i + 1, r = 2 * i + 2, largestIndex = i;
        if (l < heapSize && arr[l] > arr[largestIndex]){
            largestIndex = l;
        }
        if (r < heapSize && arr[r] > arr[largestIndex]){
            largestIndex = r;
        }
        if (largestIndex != i){
            swap(arr, i, largestIndex);
            heapify(arr, largestIndex, heapSize);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
