package 三数之和15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shan
 * @Description
 * @create 2021-01-01 22:29
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)    break;
            // 去重
            if (i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int l = i + 1, r = n - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (sum == 0){
                    // 注意添加数组的方式
                    res.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    // 去重
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    // 去重
                    while (l < r && nums[r] == nums[r - 1]) r--;
                    // 一个数组添加完后，左指针右移，右指针左移才可能使sum重新回到0
                    l++;
                    r--;
                }else if (sum < 0){
                    l++;
                }else {
                    r--;
                }
            }
        }
        return res;
    }
}