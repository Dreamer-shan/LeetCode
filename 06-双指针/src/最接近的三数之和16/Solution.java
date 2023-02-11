package src.最接近的三数之和16;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/12/27/18:53
 * @Description:
 */

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r){
                int sum = nums[i] + nums[l] + nums[r];
                if (Math.abs(sum - target) < Math.abs(target - ans)){
                    ans = sum;
                }
                if (sum == target){
                    return sum;
                }else if (sum < target){
                    l++;
                }else{
                    r--;
                }
            }
        }
        return ans;
    }
}


//class Solution {
//    public int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int ans = nums[0] + nums[1] + nums[2];
//        for (int i = 0; i < nums.length; i++) {
//            // 保证和上一次枚举的元素不相等
//            if (i > 0 && nums[i] == nums[i - 1]){
//                continue;
//            }
//            int l = i + 1, r = nums.length - 1;
//            while (l < r){
//                int sum = nums[i]+ nums[l] + nums[r];
//                if (sum == target)  return sum;
//                // 根据差值的绝对值来更新答案
//                if (Math.abs(target - sum) < Math.abs(target - ans)){
//                    ans = sum;
//                }
//
//                if (sum < target){
//                    // 如果sum小于target，移动 l 对应的指针
//                    int l0 = l + 1;
//                    while (l0 < r && nums[l0] == nums[l]){
//                        // 移动到下一个不相等的元素
//                        l0++;
//                    }
//                    l = l0;
//                }else {
//                    // 如果sum大于target，移动 r 对应的指针
//                    int r0 = r - 1;
//                    while (l < r0 && nums[r] == nums[r0]){
//                        r0--;
//                    }
//                    r = r0;
//                }
//            }
//        }
//        return ans;
//    }
//}