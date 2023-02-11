package 主要元素;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/22/15:28
 * @Description:
 */
class Solution {
    public static int majorityElement(int[] nums) {
        // 数值--出现次数
        HashMap<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(nums[i])){
                numMap.put(nums[i], numMap.get(nums[i])+1);
            }else {
                numMap.put(nums[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : numMap.entrySet()) {
            if (entry.getValue() > nums.length / 2){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static int majorityElement2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > nums.length / 2){
                return entry.getKey();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int p[] = {2,2,1,1,1,2,2};
        int a = majorityElement(p);
        System.out.println(a);
    }
}