package 排序;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/29/13:17
 * @Description:
 */
public class Sort2 {
    // 一共比较n-1轮，每轮比较n-i-1次
    public static int[] bubbleSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        int n = arr.length;
        //需进行n-1次冒泡
        for (int i = 0; i < n; i++) {
            //第一次是对n个数进行n-1次比较，进行到最后第n个的一个是最大的；
            //第二次是对n-1个数进行n-2次比较，进行到最后第n-1个的一个是最大的；
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public static int[] selectSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            int minIndex = i;
            for (int j = i; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    // 归并
    public static int[] mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        int n = arr.length;
        int mid = n / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, n);
        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] left, int[] right) {
        int m = left.length, n = right.length;
        int[] ans = new int[m + n];
        int i = 0, j = 0, index = 0;
        while (i < m && j < n) {
            if (left[i] <= right[j]) {
                ans[index++] = left[i++];
            } else {
                ans[index++] = right[j++];
            }
        }
        while (i < m) { ans[index++] = left[i++]; }
        while (j < n) { ans[index++] = right[j++]; }
        return ans;
    }


    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int temp = arr[low];
        while (low < high){
            while (low < high && arr[high] >= temp){ high--; }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp){ low++; }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    // 一般升序采用大顶堆，降序采用小顶堆
//    a.将无需序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆;
//　　b.将堆顶元素与末尾元素交换，将最大元素"沉"到数组末端;
//　　c.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
    public static void heapSort(int[] arr){
        if (arr == null || arr.length <= 1) return;
        int heapSize = arr.length;
        buildHeap(heapSize, arr);
        for (int i = heapSize - 1; i > 0; i--) {
            swap(arr, i, 0);
            heapSize--;
            heapify(arr, 0, heapSize);
        }
    }
    private static void buildHeap(int heapSize, int[] arr) {
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            heapify(arr, i, heapSize);
        }
    }
    private static void heapify(int[] arr, int i, int heapSize) {
        int l = 2 * i + 1, r = 2 * i + 2, largeIndex = i;
        if (l < heapSize && arr[l] > arr[largeIndex])   largeIndex = l;
        if (r < heapSize && arr[r] > arr[largeIndex])   largeIndex = r;
        if (largeIndex != i){
            swap(arr, i, largeIndex);
            heapify(arr, largeIndex, heapSize);
        }
    }

    public static void bucketSort(int[] arr){

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < arr.length; i++){
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for(int i = 0; i < bucketNum; i++){
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for(int i = 0; i < arr.length; i++){
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        //对每个桶进行排序
        for(int i = 0; i < bucketArr.size(); i++){
            Collections.sort(bucketArr.get(i));
        }
        int index = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            for (int j = 0; j < bucketArr.get(i).size(); j++) {
                arr[index++] = bucketArr.get(i).get(j);
            }
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
            double random = Math.random();
            arr[i] = (int) (random * 100);
        }
//        System.out.println(Arrays.toString(arr));
//        int[] sortedArr1 = bubbleSort(arr);
//        System.out.println(Arrays.toString(sortedArr1));

//        System.out.println(Arrays.toString(arr));
//        int[] sortedArr2 = selectSort(arr);
//        System.out.println(Arrays.toString(sortedArr2));

//        System.out.println(Arrays.toString(arr));
//        int[] sortedArr3 = mergeSort(arr);
//        System.out.println(Arrays.toString(sortedArr3));

//        System.out.println(Arrays.toString(arr));
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));


//        System.out.println(Arrays.toString(arr));
//        bucketSort(arr);
//        System.out.println(Arrays.toString(arr));

//        System.out.println(Arrays.toString(arr));
//        heapSort(arr);
//        System.out.println(Arrays.toString(arr));

        int[] num = {1,2,3};
        fun(num);
        System.out.println(Arrays.toString(num));

    }
    static void fun(int[] num){
        num[0] = 0;
    }
}
