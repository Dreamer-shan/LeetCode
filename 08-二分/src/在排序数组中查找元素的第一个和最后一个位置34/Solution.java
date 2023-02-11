package 在排序数组中查找元素的第一个和最后一个位置34;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/07/16:30
 * @Description:
 */
public class Solution {

    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        int firstPosition = findFirstPosition(nums, target);
        // 如果第 1 次出现的位置都找不到，肯定不存在最后 1 次出现的位置
        if (firstPosition == -1) {
            return new int[]{-1, -1};
        }
        int lastPosition = findLastPosition(nums, target);
        return new int[]{firstPosition, lastPosition};
    }

    private int findFirstPosition(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                r = mid - 1;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        if (l != nums.length && nums[l] == target){
            return l;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r){
            int mid = l + (r - l) / 2;
            if (nums[mid] == target){
                l = mid + 1;
            }else if (nums[mid] < target){
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        if (r != -1 && nums[r] == target) {
            return r;
        }
        return -1;

    }


}





