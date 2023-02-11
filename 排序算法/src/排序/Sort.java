package 排序;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Shan
 * @Description
 * @create 2021-02-23 21:45
 */
public class Sort {
    public int[] bubbleSort(int[] arr){
        if (arr.length <= 1){
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        return arr;
    }

    /*
    首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置
    然后，再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
     */
    public int[] selectSort(int[] arr){
        if (arr.length <= 1){
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len; i++) {

            int minIndex = i;
            for (int j = i; j < len; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;   //将最小数的索引保存
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    // 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
    // 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。如此反复循环，直到全部排好顺序
    public int[] insertSort(int[] arr){
        if (arr.length <= 1){
            return arr;
        }
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int curValue = arr[i + 1];  // 当前值
            int preIndex = i;   // 前一个值的索引
            while(preIndex >= 0 && curValue < arr[preIndex]){
                arr[preIndex + 1] = arr[preIndex];  // 后移一位
                preIndex--; // 从后往前遍历，preIndex是有序序列的最后一个元素的索引
            }
            arr[preIndex + 1] = curValue;   // curValue放到正确位置
        }
        return arr;
    }


    public int[] ShellSort(int[] arr){
        if (arr.length <= 1){
            return arr;
        }
        int len = arr.length;
        int curValue, gap = len / 2;
        while (gap > 0){
            for (int i = gap; i < len; i++) {
                curValue = arr[i];
                int preIndex = i - gap;
                while (preIndex >= 0 && curValue < arr[preIndex]){
                    arr[preIndex + gap] = arr[preIndex];
                    preIndex -= gap;
                }
                arr[preIndex + gap] = curValue;
            }
            gap /= 2;
        }
        return arr;
    }

    public  int[] MergeSort(int[] arr){
        if (arr.length <= 1){
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(MergeSort(left), MergeSort(right));
    }

    /**
     *
     * @param left
     * @param right
     * @return
     */
    int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < res.length; index++){
            if (i >= left.length){
                res[index] = right[j++];
            }else if (j >= right.length){
                res[index] = left[i++];
            }else if (left[i] > right[j]){
                res[index] = right[j++];
            }else {
                res[index] = left[i++];
            }
        }
        return res;
    }
}




