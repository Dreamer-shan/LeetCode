import java.util.*;

/**
 * @author Shan
 * @Description
 * @create 2021-04-18 16:01
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0){
                nums[i] = sc.nextInt();
            }else {
                nums[i] = -sc.nextInt();
            }
        }
        int res = nums[0];
        int[][] dp = new int[n + 1][2];
        dp[0][0] = nums[0];
        for (int i = 1; i < n; i++) {
            int k = nums[i];
            dp[i][0] = Math.max(dp[i-1][0]+k,k);
            if (k < 0 && i % 2 == 1){
                if (dp[i-1][0]+k> -k){
                    dp[i][0] = dp[i-1][0] + k;
                }else {
                    dp[i][1]=1;
                    dp[i][0]=-k;
                }
            }else {
                if (dp[i-1][1] == 1){
                    if (dp[i-1][0] < nums[i]){
                        dp[i][0] = nums[i];
                    }
                }
            }
            res = Math.max(dp[i][0], res);
        }
        System.out.println(res);
    }
}



