package 携程;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/09/19:34
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer> karr = new ArrayList<>();
        ArrayList<Integer> xarr = new ArrayList<>();
//        int[] karr = new int[m];
//        int[] xarr = new int[m];
        char[] strs = sc.nextLine().toCharArray();
        System.out.println(Arrays.toString(strs));
        while (m-- > 0){
            String[] split = sc.nextLine().split(" ");
            System.out.println(split);
            int k = Integer.valueOf(split[0]);
            int x = Integer.valueOf(split[1]);
            karr.add(k);
            xarr.add(x);
        }
        int left = 0, right = 0;
        int ans = 0;
        while (true){
            if (left >= strs.length - 1)  break;
            while (strs[left] == '0'){
                left++;
            }
            if (left >= strs.length - 1)  break;
            right = left + 1;
            while (right < strs.length && strs[right] != '0'){
                right++;
            }
            int count = right - left;
            int[] dp = new int[count + 1];
            for (int i = 0; i < karr.size(); i++) {
                for(int j = karr.get(i); j <= count; j++){
                    dp[j] = Math.max(dp[j], dp[j - karr.get(i)] + xarr.get(i));
                }
            }
            ans += dp[count];
            left = right + 1;
        }
        System.out.println(ans);
    }
}
