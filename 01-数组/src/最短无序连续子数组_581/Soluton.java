package 最短无序连续子数组_581;

import java.awt.print.Pageable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/25/10:15
 * @Description:
 */
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int start = nums.length, end = 0;
        for (int i = 0; i < clone.length; i++) {
            if (clone[i] != nums[i]){
                start = Math.min(start, i);
                end = Math.max(end, i);
            }
        }
        return (end-start >= 0? end-start+1:0);
    }
}



//class Solution {
//    public static int findUnsortedSubarray(int[] nums) {
//        int len = nums.length;
//        int max = nums[0], min = nums[len-1];
//        int left = 0, right = 1;
//        for (int i = 0; i < len; i++) {
//            if (max > nums[i]){
//                right = i;
//            }else {
//                max = nums[i];
//            }
//            if (min < nums[len-1-i]){
//                left = len-1-i;
//            }else {
//                min = nums[len-1-i];
//            }
//        }
//        return right-left+1;
//    }
//
//    public static void main(String[] args) {
//        int[] p = {2, 6, 4, 8, 10, 9, 15};
//        int i = findUnsortedSubarray(p);
//        System.out.println(i);
//    }
//}