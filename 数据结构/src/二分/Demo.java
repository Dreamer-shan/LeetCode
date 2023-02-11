package 二分;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/03/07/13:51
 * @Description:
 */
public class Demo {
    // 无重复元素
    public int binarySearch(int[] arr, int value){
        int left = 0, right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == value){
                return mid;
            }else if (arr[mid] < value){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        return -1;
    }
    // 递归版本
    public int recurBinarySearch(int[] arr, int value, int left, int right){
        if (left >= right)  return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == value){
            return mid;
        }else if (arr[mid] < value){
            return recurBinarySearch(arr, value, mid + 1, right);
        }else {
            return recurBinarySearch(arr, value, left, mid - 1);
        }
    }

    // 查找 target 出现的第 1 个位置
    private int findFirstPosition1(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                // 在mid元素 == target的情况下，如果mid就是第一个位置 或者 mid的前一个位置不是target，说明mid就是第一次出现的位置
                if(mid == 0 || nums[mid - 1] != target){
                    return mid;
                // mid前面还有跟target相等的元素，继续在左边查找
                }else{
                    r = mid - 1;
                }
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // 查找 target 出现的最后一个位置
    private int findLastPosition1(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                // 在mid元素 == target的情况下，如果mid就是最后一个 或者 mid的后一个元素不是target，说明mid就是最后一次出现的位置
                if(mid == nums.length - 1 || nums[mid + 1] != target){
                    return mid;
                    // mid后面还有跟target相等的元素，继续在右边查找
                }else{
                    l = mid + 1;
                }
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }

    // 查找第 1 个 >= target的位置
    private int findFirstPosition2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target){
                // 在mid元素 >= target的情况下 如果mid就是第一个位置 或者 mid的前一个位置 <target，说明mid就是第一个 >=target 的位置返回mid
                if(mid == 0 || nums[mid - 1] < target){
                    return mid;
                    // mid前面还有 >= target的元素， 向左查找
                }else{
                    r = mid - 1;
                }
            }else if (nums[mid] < target){
                l = mid + 1;
            }
        }
        // 边界情况  比如[1,2,3,4],搜索5,此时应该返回数组长度
        return l;
    }

    // 查找最后一个 <= target的位置
    private int findLastPosition2(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target){
                // 如果mid就是最后一个位置 或者 mid的后一个位置大于target，返回mid
                if(mid == nums.length - 1 || nums[mid + 1] > target){
                    return mid;
                    // mid后面还有跟target相等的元素，向右查找
                }else{
                    l = mid + 1;
                }
            }else if (nums[mid] > target){
                r = mid - 1;
            }
        }
        // 边界情况  比如[1,2,3,4],搜索0,此时应该返回 0
        return l;
    }




    public static void main(String[] args) {
        Demo demo = new Demo();
//        int[] arr = {6,12,15,19,24,29,29,29,46,67};
        int[] arr = {1,2,3,4};
//        int index = demo.binarySearch(arr, 15);
//        System.out.println("目标元素下标：" + index + " ---对应值为：" + arr[index]);
//        int index = demo.recurBinarySearch(arr, 15, 0, arr.length - 1);
//        System.out.println("目标元素下标：" + index + " ---对应值为：" + arr[index]);
        for (int i = 0; i < 10; i++) {
            int index1 = demo.findFirstPosition2(arr, i);
            System.out.println("目标元素下标：" + index1);
        }

//        System.out.println("目标元素下标：" + index2 + " ---对应值为：" + arr[index2]);
    }
}

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0)   return 0;
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + ( r - l) / 2;
            if (nums[mid] < target){
                l = mid + 1;
            }else if (nums[mid] > target){
                r = mid - 1;
            }else {
                return mid;
            }
        }
        return l;
    }
}



