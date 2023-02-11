package 奇安信;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/23/15:59
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {

    }

    public int getMinLength (int[][] pearls) {
        // write code here
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[pearls.length][pearls.length];
        for (int i = 0; i < pearls.length; i++) {
            for (int j = 0; j < pearls.length; j++) {
                if (i == j){
                    dp[i][j] = Integer.MAX_VALUE;
                }else {
                    dp[i][j] = Math.abs(pearls[i][0] - pearls[j][0]) + Math.abs(pearls[i][1] - pearls[j][1]);
                }
            }
        }
        for (int i = 0; i < pearls.length; i++) {
            int min0, min1;
            if (dp[i][0] > dp[i][1]){
                min0 = dp[i][1];
                min1 = dp[i][0];
            }else {
                min0 = dp[i][0];
                min1 = dp[i][1];
            }
            for (int j = 2; j < pearls.length; j++) {
                if (dp[i][j] >= min1)   continue;
                if (dp[i][j] < min0){
                    min1 = min0;
                    min0 = dp[i][j];
                }else {
                    min1 = dp[i][j];
                }

            }
            if (min0+min1<min)  min = min0+min1;
        }
        return min;
    }
}
