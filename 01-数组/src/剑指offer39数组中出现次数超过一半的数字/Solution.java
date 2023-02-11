package 剑指offer39数组中出现次数超过一半的数字;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/22/20:51
 * @Description:
 */
class Solution {
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }

    public static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println(majorityElement(arr));
    }
}

//class Solution {
//    public int majorityElement(int[] nums) {
//        int x = 0, votes = 0;
//        for (int num : nums) {
//            if (votes == 0) x = num;
//            votes += x == num ? 1 : -1;
//        }
//        return x;
//    }
//}

//class Solution {
//    public int majorityElement(int[] nums) {
//        int x = 0, votes = 0, count = 0;
//        for (int num : nums) {
//            if (votes == 0) x = num;
//            votes += num == x ? 1 : -1;
//        }
//        // 验证 x 是否为众数
//        for (int num : nums)
//            if (num == x) count++;
//        return count > nums.length / 2 ? x : 0; // 当无众数时返回 0
//    }
//}
//
//
//public class Solution {
//    // you need to treat n as an unsigned value
//    public int hammingWeight(int n) {
//        int count = 0;
//        int i = 32;
//        while (i > 0) {
//            if ((n & 1) == 1) {
//                count++;
//            }
//            n >>= 1;
//            i--;
//        }
//        return count;
//    }
//}
//
//public class Solution {
//    public int hammingWeight(int n) {
//        int res = 0;
//        while (n != 0) {
//            res += n & 1;
//            n >>>= 1;
//        }
//        return res;
//    }
//}



