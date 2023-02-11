import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @author Shan
 * @Description
 * @create 2021-08-01 17:12
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n + 1];
        int[] pre = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            A[i] = sc.nextInt();
        }
        int temp = Integer.MIN_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for(int j = 1; j < i; j++){
                if (A[j] > A[j - 1] && A[j] < A[i]){
                    pre[i] = Math.max(temp, A[j]);
                }
            }
        }
        int sum = 0;
        for (int i = 1; i < n + 1; i++) {
            sum += pre[i] * i ;
        }
        System.out.println(sum);
    }
}
