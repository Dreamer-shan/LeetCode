
import java.util.Scanner;

/**
 * @author Shan
 * @Description
 * @create 2021-04-24 13:59
 */
public class Solution2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] day = new int[64];
        day[0] = 1;
        for (int i = 1; i < 64; i++) {
            day[i] = day[i - 1] * 2;
        }
        for (int i = 0; i < T; i++) {
            int n = sc.nextInt();
            for (int j = 0; j < 64; j++) {
                if (n <= day[j]){
                    System.out.println(j + 1);
                    break;
                }
            }
        }
    }
}
