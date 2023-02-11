package 排序算法;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/04/06/10:24
 * @Description:
 */
public class SortPractice {
    public static int[] bubbleSort(int[] arr) {

        if (arr.length <= 1) return arr;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean isComplete = true;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    isComplete = false;
                }
            }
            if (isComplete) {
                break;
            }

        }
        return arr;
    }

    public static int[] selectSort(int[] arr){
        if (arr.length <= 1)    return arr;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i;
//           有序区R[1..i-1]  无序区R(i..n）  从剩余未排序元素中继续寻找最小元素
            for (int j = i; j < len; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
        return arr;
    }

    public static int[] insertSort(int[] arr){
        if (arr.length <= 1)    return arr;
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int insertValue = arr[i + 1];
            int insertIndex = i;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex + 1] = insertValue;
        }
        return arr;
    }

    public static int[] shellSort(int[] arr){
        if (arr.length <= 1)    return arr;
        int len = arr.length;
        int gap = len / 2;
        while (gap > 0){
            for (int i = gap; i < len; i++) {
                int insertValue = arr[i];
                int insertIndex = i - gap;
                while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                    arr[insertIndex + gap] = arr[insertIndex];
                    insertIndex -= gap;
                }
                arr[insertIndex + gap] = insertValue;
            }
            gap /= 2;
        }
        return arr;
    }

    public static int[] mergeSort(int[] arr){
        if (arr.length <= 1)    return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        // 左边分 ---- 右边分 ---- 整个数组合
        return merge(mergeSort(left), mergeSort(right));
    }
    public static int[] merge(int[] left,int[] right){
        int[] res = new int[left.length + right.length];
        int l1 = 0, l2 = 0, index = 0;
        while (l1 < left.length && l2 < right.length){
            if (left[l1] <= right[l2]){
                res[index++] = left[l1];
                l1++;
            }else {
                res[index++] = right[l2];
                l2++;
            }
        }
        while (l1 < left.length){
            res[index++] = left[l1++];
        }
        while (l2 < right.length){
            res[index++] = left[l2++];
        }
        return res;
    }

    /**
     * 插入排序
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        if (array.length == 0)
            return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }
}
