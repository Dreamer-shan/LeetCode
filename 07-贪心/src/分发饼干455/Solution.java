package 分发饼干455;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/01/12:38
 * @Description:
 */

class Solution {
    /**
     *
     * @param g  孩子的胃口值
     * @param s  饼干大小
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        while (i < g.length && j < s.length){
            if (s[j] >= g[i] ){
                i++;
            }
            j++;
        }
        return i;
    }

    public int findContentChildren2(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;   // 饼干数组下标
        int result = 0;
        for (int i = g.length - 1; i >= 0; i--) {
            if (index >= 0 && s[index] >= g[i]){
                result++;
                index--;
            }
        }
        return result;
    }
}