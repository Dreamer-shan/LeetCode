package 删除排序数组中的重复项26;

/**
 * @author Shan
 * @Description
 * @create 2021-01-01 23:01
 */
class Solution {
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)   return 0;
        int p = 0, q = 1;
        while (q < nums.length){
            if (nums[p] == nums[q]){
                q++;
            }else {
                nums[p + 1] = nums[q];
                p++;
            }
        }
        return p+1;
    }

    public static int removeDuplicates2(int[] nums) {
        if (nums.length == 0)   return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]){
                nums[i + 1] = nums[j];
                i++;
            }
            i++;
        }
        return i + 1;
    }
}

