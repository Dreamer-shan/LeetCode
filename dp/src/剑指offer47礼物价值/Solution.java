package 剑指offer47礼物价值;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Shan
 * @Description
 * @create 2021-01-25 11:05
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int i = -1, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))){
                i = Math.max(i, map.get(s.charAt(j)));
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i);
        }
        return res;
    }

    public int lengthOfLongestSubstring2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(right);
            if (map.containsKey(ch)){
                left = Math.max(left, map.get(ch) + 1);
            }
            map.put(ch, right);
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}




