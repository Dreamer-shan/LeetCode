package 找出数组游戏的赢家;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/23/19:45
 * @Description:1535题
 */

class Solution {
    public int getWinner(int[] arr, int k) {
        // 第一回合游戏中取得胜利的整数
        int prev = Math.max(arr[0], arr[1]);
        if (k == 1){
            return prev;
        }
        // 第一回合后，连胜次数为1
        int consecutive = 1;
        // 记录数组arr中的最大值
        int maxNum = prev;
        for (int i = 2; i < arr.length; i++) {
            int curr = arr[i];
            if (curr < prev){
                consecutive++;
                if (consecutive == k){
                    return prev;
                }
            }else {
                consecutive = 1;
                prev = curr;
            }
            maxNum = Math.max(curr, maxNum);
        }
        // arr遍历完，此时maxNum是arr中最大的数，该数最后一定会连续赢得k个回合
        return maxNum;
    }
}