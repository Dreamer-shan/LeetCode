package 排序测试;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/03/06/15:02
 * @Description:
 */

import 排序算法.Sort;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Shan
 * @Description
 * @create 2021-02-23 21:49
 */
public class Test {
    public static void main(String[] args) {
        Sort sort = new Sort();
        int[] arr = new int[10];
//        int[] arr = {1,2,3,3,2,4,5,5,6,1};
        for (int i = 0; i < 10; i++) {
            double random = Math.random();
            arr[i] = (int) (random * 100);
        }


        System.out.println("原数组: " + Arrays.toString(arr));
//        int[] bubbleSort = sort.bubbleSort(arr);
//        System.out.println("冒泡排序: " + Arrays.toString(bubbleSort));
//        int[] selectSort = sort.selectSort(arr);
//        System.out.println("选择排序: " + Arrays.toString(selectSort));
//        int[] insertSort = sort.insertSort(arr);
//        System.out.println("插入排序: " + Arrays.toString(insertSort));
//        int[] shellSort = sort.ShellSort(arr);
//        System.out.println("希尔排序: " + Arrays.toString(shellSort));
//        int[] mergeSort = sort.MergeSort(arr);
//        System.out.println("归并排序: " + Arrays.toString(mergeSort));
//        sort.quickSort1(arr, 0 , arr.length - 1);
//        System.out.println("快速排序1: " + Arrays.toString(arr));
//        sort.quickSort2(arr, 0 , arr.length - 1);
//        System.out.println("快速排序2: " + Arrays.toString(arr));
//        List<Integer> list = sort.bucketSort(ls, 2);
//        System.out.println(list);
//        sort.countSort2(arr);
//        System.out.println(Arrays.toString(arr));
//        sort.heapSort(arr);
//        System.out.println(Arrays.toString(arr));

    }
}