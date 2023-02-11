package src.划分字母区间763;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/07/16:12
 * @Description:
 */
class Solution {
    public List<Integer> partitionLabels(String S) {
        int n = S.length();
        int[] last = new int[26];
        int start = 0, end = 0;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            last[S.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < n; i++){
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if(i == end){
                ans.add(end - start + 1);
                start = end + 1;
            }
        }
        return ans;
    }
}