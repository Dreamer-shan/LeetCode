package 最接近的三数之和16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shan
 * @Description
 * @create 2021-01-01 22:30
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n; i++) {
            if (i  > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(target - sum) < Math.abs(target - ans)){
                    ans = sum;
                }
                if (sum == target){
                    return target;
                }else if (sum < target){
                    int l0 = l + 1;
                    while (l0 < r && nums[l] == nums[l0]){
                        l0++;
                    }
                    l = l0;
                }else {
                    int r0 = r - 1;
                    while (l < r0 && nums[r] == nums[r0]){
                        r0--;
                    }
                    r = r0;
                }
            }
        }
        return ans;
    }
}

//class Solution {
//    public static List<List<Integer>> threeSum(int[] nums) {
//
//        List<List<Integer>> ans = new ArrayList<>();
//        int n = nums.length;
//        if (n < 3) return ans;
//        Arrays.sort(nums); // 排序
//        for (int i = 0; i < n; i++) {
//            if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
//            if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重
//            int L = i + 1;
//            int R = n - 1;
//            while (L < R) {
//                int sum = nums[i] + nums[L] + nums[R];
//                if (sum == 0) {
//                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
//                    while (L < R && nums[L] == nums[L + 1]) L++; // 去重
//                    while (L < R && nums[R] == nums[R - 1]) R--; // 去重
//                    L++;
//                    R--;
//                } else if (sum < 0) L++;
//                else if (sum > 0) R--;
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        int[] a = {-1, 0, 1, 2, -1, -4};
//        List<List<Integer>> lists = threeSum(a);
//    }
//}