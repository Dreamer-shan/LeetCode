/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/30/19:40
 * @Description:
 */


public class Solution {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return nums[0] == target ? 0 : -1;
        }
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[0] <= nums[mid]) {
                if (nums[0] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[n - 1]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s = "asd";
        for (int i = 0; i < s.toCharArray().length; i++) {
            
        }
        int[] num2 = { 2, 6, 8, 9, 5, 4};
        int[] num = {1,3,4,7,8,5,2};
        System.out.println(search(num, 4));
        System.out.println(search(num2, 3));
    }
}
