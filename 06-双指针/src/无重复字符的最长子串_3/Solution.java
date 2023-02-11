package src.无重复字符的最长子串_3;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/01/12:35
 * @Description:
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        int left = 0, max = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            // 当出现了重复的字符串时，left要从上一次出现的字符的后面一位开始，保证i和left之间没有重复的字符
            if(map.containsKey(s.charAt(i))){
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i), i);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}

//class Solution {
//    public int lengthOfLongestSubstring(String s) {
//        if(s.length() == 0) return 0;
//        int left = 0, max = 0;
//        // 以当前位置结尾的不重复最长子串的索引
//        int[] chars = new int[128];
//        Arrays.fill(chars, -1);
//        for(int i = 0; i < s.length(); i++){
//            left = Math.max(left, chars[s.charAt(i)] + 1);
//            max = Math.max(max, i - left + 1);
//            chars[s.charAt(i)] = i;
//        }
//        return max;
//    }
//}




