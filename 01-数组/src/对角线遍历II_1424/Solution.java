package 对角线遍历II_1424;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/27/10:27
 * @Description:
 */
class Solution {
    public static int[] findDiagonalOrder(List<List<Integer>> nums) {
        // 数字总个数
        int len = 0;
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        // 遍历矩阵
        for (int i = 0; i < nums.size(); i++) {
            // 每一行有多少个数字
            len += nums.get(i).size();
            for (int j = 0; j < nums.get(i).size(); j++) {
                // 哈希表中是否存在 （i+j） 键
                if (map.containsKey(i+j)){
                    // 如果存在，直接哈希表的值（list）中追加一个元素。
                    map.get(i+j).add(nums.get(i).get(j));
                }else {
                    // 新建一个list存放对角线的第一个元素（右上方）
                    List<Integer> list = new ArrayList<>();
                    list.add(nums.get(i).get(j));
                    map.put(i+j, list);
                }
            }
        }
        int[] ans = new int[len];
        int index = 0;
        // 遍历哈希表
        for (Integer key : map.keySet()) {
            // 哈希表的 值  也就是List
            List<Integer> list = map.get(key);
            // List逆序存放
            for (int i = list.size() - 1; i >= 0; i--) {
                ans[index++] = list.get(i);
            }
        }
        return ans;
    }

//    public static void main(String[] args) {
//        ArrayList<List<Integer>> nums = new ArrayList<>();
//        nums.add(List.of(1,2,3));
//        nums.add(List.of(4,5,6));
//        nums.add(List.of(7,8,9));
//        int[] diagonalOrder = findDiagonalOrder(nums);
//        System.out.println(diagonalOrder);
//    }
}