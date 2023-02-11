package 排序测试;

import 排序.Sort;

import java.util.Arrays;

/**
 * @author Shan
 * @Description
 * @create 2021-02-23 21:49
 */
public class Test {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = new int[30];

        for (int i = 0; i < 30; i++) {
            double random = Math.random();
            arr[i] = (int) (random * 100);
        }
        System.out.println("原数组: " + Arrays.toString(arr));
        int[] bubbleSort = sort.bubbleSort(arr);
        System.out.println("冒泡排序: " + Arrays.toString(bubbleSort));
        int[] selectSort = sort.selectSort(arr);
        System.out.println("选择排序: " + Arrays.toString(selectSort));
        int[] insertSort = sort.insertSort(arr);
        System.out.println("插入排序: " + Arrays.toString(insertSort));
        int[] shellSort = sort.ShellSort(arr);
        System.out.println("希尔排序: " + Arrays.toString(shellSort));
        int[] mergeSort = sort.MergeSort(arr);
        System.out.println("归并排序: " + Arrays.toString(mergeSort));
    }
}
