package 存在重复元素;

/**
 * @author Shan
 * @Description
 * @create 2020-11-25 14:06
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (nums[i] == nums[j] && Math.abs(i-j)==k){
                    return true;
                }
            }
        }
        return false;
    }
}
