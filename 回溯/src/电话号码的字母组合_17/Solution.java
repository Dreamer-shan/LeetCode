package 电话号码的字母组合_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Shan
 * @Description
 * @create 2020-12-19 17:52
 */
//class Solution {
//    public static List<String> letterCombinations(String digits) {
//        // 存储答案
//        List<String> combinations = new ArrayList<>();
//        // 特殊情况
//        if (digits.length() == 0) {
//            return combinations;
//        }
//        Map<Character, String> phoneMap = new HashMap<>();
//        phoneMap.put('2', "abc");
//        phoneMap.put('3', "def");
//        phoneMap.put('4', "ghi");
//        phoneMap.put('5', "jkl");
//        phoneMap.put('6', "mno");
//        phoneMap.put('7', "pqrs");
//        phoneMap.put('8', "tuv");
//        phoneMap.put('9', "wxyz");
//        backtrack(combinations, phoneMap, digits, 0, new StringBuffer());
//        return combinations;
//    }
//
//    // 需要一个List容器combinations来装返回的字符数组，map，传入的字符串digits，字符串第几个数index，构造字符串StringBuffer combination
//    static void backtrack(List<String> combinations, Map<Character, String> map, String digits, int index, StringBuffer combination) {
//        // 如果字符个数==digits的长度 将字符串装入容器
//        if (index == digits.length()) {
//            combinations.add(combination.toString());
//        } else {
//            // （2747852....）键盘的第index个键
//            char c = digits.charAt(index);
//            // 第index个键对应的字母
//            String letters = map.get(c);
//            int len = letters.length();
//            for (int i = 0; i < len; i++) {
//                // 字符串拼接
//                combination.append(letters.charAt(i));
//                // 深入递归
//                backtrack(combinations, map, digits, index + 1, combination);
//                // 回溯删除最后最后一个字母  如ad删除d后继续深入递归为ae
//                // 如果不删除就会变成[ad, ade, adef, adefbd, adefbde, adefbdef, adefbdefcd, adefbdefcde, adefbdefcdef]
//                combination.deleteCharAt(index);
//            }
//        }
//    }
//}

//class Solution {
//    //这里也可以用map，用数组可以更节省点内存
//    String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//    //最终输出结果的list
//    List<String> res = new ArrayList<>();
//    public List<String> letterCombinations(String digits){
//        if (digits.length()==0){
//            return res;
//        }
//        iterStr(new StringBuffer(), digits, 0);
//        return res;
//    }
//    void iterStr(StringBuffer combination, String str, int index){
//        if (index==str.length()){
//            res.add(combination.toString());
//        }else {
//            char c = str.charAt(index);
//            String letters = letter_map[c - '0'];
//            for (int i = 0; i < letters.length(); i++) {
//                combination.append(letters.charAt(i));
//                iterStr(combination, str, index+1);
//                combination.deleteCharAt(index);
//            }
//        }
//    }
//}

class Solution {
    String[] letter_map = {" ", "*", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0){
            return res;
        }
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            String letters = letter_map[digits.charAt(i) - '0'];
            int size = res.size();
            for (int j = 0; j < size; j++) {
                String s = res.remove(0);
                for (int k = 0; k < letters.length(); k++) {
                    res.add(s+letters.charAt(k));
                }
            }
        }
        return res;
    }
}