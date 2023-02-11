package 堆排序;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/24/10:16
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,2,5,9,4,3};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void heapSort(int[] arr){
        if (arr == null || arr.length == 0)  return;
        int heapSize = arr.length;
        // 建堆
        buildMaxHeap(arr, heapSize);
        // 交换堆顶和当前末尾的节点，重置大顶堆
        for (int i = heapSize - 1; i > 0; i--) {
            // 交换堆顶和当前末尾的节点
            swap(arr, 0, i);
            // 把末尾结点从树中切断
            heapSize--;
            // 对堆顶元素也就是下标为0的元素做heapify操作
            heapify(arr, 0, heapSize);
        }

    }
    public static void buildMaxHeap(int[] arr, int heapSize){
        // 从最后一个非叶子结点开始，从右到左从下到上heapify
        for (int i = heapSize / 2; i >= 0; i--) {
           heapify(arr, i, heapSize);
        }
    }

    //  表示对哪个结点做heapify操作
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
