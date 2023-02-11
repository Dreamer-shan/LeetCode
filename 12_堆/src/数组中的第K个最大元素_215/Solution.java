package 数组中的第K个最大元素_215;
//
import java.util.Arrays;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/06/23/19:54
// * @Description:
// */
//// 大根堆是升序
public class Solution {
    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        int i = findKthLargest(arr, 1);
//        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static int findKthLargest(int[] nums, int k ){
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0 , heapSize);
        }
        return nums[0];
    }

    public static void heapSort(int[] nums){
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i > 0; i--) {
            swap(nums, 0, i);
            heapSize--;
            maxHeapify(nums, 0 , heapSize);
        }
    }

    public static void  buildMaxHeap(int[] arr, int heapSize){
        //从第一个非叶子结点从下至上，从右至左调整结构
        for (int i = heapSize / 2 - 1; i >= 0; i--) {
            maxHeapify(arr, i, heapSize);
        }
    }

    private static void maxHeapify(int[] arr, int i, int heapSize) {
        // 先根据堆性质，找出它左右节点的索引  默认当前节点（父节点）是最大值
        int l = 2 * i + 1, r = 2 * i + 2, largest = i;
        // 如果有左节点，并且左节点的值更大，更新最大值的索引
        if (l < heapSize && arr[l] > arr[largest]){
            largest = l;
        }
        if (r < heapSize && arr[r] > arr[largest]){
            largest = r;
        }
        if (largest != i){
            // 如果最大值不是当前非叶子节点的值，那么就把当前节点和最大值的子节点值互换
            swap(arr, i, largest);
            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整。
            maxHeapify(arr, largest, heapSize);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public void maxHeapify1(int[] arr, int i, int heapSize){
        int left = 2 * i + 1, right = 2 * i + 2, largest = i;
        if (left < heapSize && arr[left] > arr[largest]){
            largest = left;
        }
        if (right < heapSize && arr[right] > arr[largest]){
            largest = right;
        }
        if (largest != i){
            swap(arr, i, largest);
            maxHeapify1(arr, largest, heapSize);
        }
    }
}
//class Solution {
//    public static void main(String[] args) {
//        int[] a = {3,2,1,5,6,4};
//        int i = findKthLargest(a, 2);
//        System.out.println(i);
//    }
//    public static int findKthLargest(int[] nums, int k) {
//        int heapSize = nums.length;
//        buildMaxHeap(nums, heapSize);
//        for(int i = nums.length - 1; i >= nums.length - k + 1; i--){
//            swap(nums, 0, i);
//            heapSize--;
//            maxHeapify(nums, 0, heapSize);
//        }
//        return nums[0];
//    }
//    public static void buildMaxHeap(int[] nums,int heapSize){
//        for(int i = heapSize / 2 - 1; i >= 0; i--){
//            maxHeapify(nums, i, heapSize);
//        }
//    }
//    public static void maxHeapify(int[] nums, int i ,int heapSize){
//        int l = 2 * i + 1, r = 2 * i + 2, largestIndex = i;
//        if(l < heapSize && nums[l] > nums[largestIndex]){
//            largestIndex = l;
//        }
//        if(r < heapSize && nums[r] > nums[largestIndex]){
//            largestIndex = r;
//        }
//        if(largestIndex != i){
//            swap(nums, i, largestIndex);
//            maxHeapify(nums, largestIndex, heapSize);
//        }
//    }
//    public static void swap(int[] nums, int i, int j){
//        int temp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = temp;
//    }
//}