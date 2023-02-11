package src.长度最小的子数组209;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/03/20:29
 * @Description:
 */

//class Solution {
//    public static int minSubArrayLen(int s, int[] nums) {
//        if (nums.length == 0)   return 0;
//        int n = nums.length;
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < n; i++) {
//            int sum = 0;
//            for (int j = i; j < n; j++) {
//                sum += nums[j];
//                if (sum >= s){
//                    ans = Math.min(ans, j - i + 1);
//                    break;
//                }
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }
//    public static int minSubArrayLen2(int s, int[] nums) {
//        if (nums.length == 0)   return 0;
//        int n = nums.length;
//        int ans = Integer.MAX_VALUE;
//        int start = 0, end = 0;
//        int sum = 0;
//        while (end < n){
//            sum += nums[end];
//            while (sum >= s){
//                ans = Math.min(ans, end - start + 1);
//                sum -= nums[start];
//                start++;
//            }
//            end++;
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }
//
//    public static void main(String[] args) {
//        int[] a = {2,3,1,2,4,3};
//        System.out.println(minSubArrayLen(7, a));
//    }
//}
//
//class Solution {
//    public int searchInsert(int[] nums, int target) {
//        if (nums.length == 0)   return 0;
//        int l = 0, r = nums.length - 1;
//        while (l <= r){
//            int mid = l + ( r - l) / 2;
//            if (nums[mid] < target){
//                l = mid + 1;
//            }else if (nums[mid] > target){
//                r = mid - 1;
//            }else {
//                return mid;
//            }
//        }
//        return l;
//    }
//}