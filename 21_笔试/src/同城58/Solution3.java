package 同城58;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/11/20:53
 * @Description:
 */
public class Solution3 {
    public int getTeams (int[] heros) {
        // write code here
        int[] temp = new int[5];
        for (int hero : heros) {
            temp[hero]++;
        }
        int res = 1;
        for (int i = 0; i < 5; i++) {
            res *= temp[i];
        }
        return res;
    }
}
