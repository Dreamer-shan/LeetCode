package Vmware;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/18/19:39
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] value = new int[m][m];
//        System.out.println(m);
//        System.out.println(n);
        for (int i = 0; i < m; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            int score = sc.nextInt();
            value[row][col] = value[col][row] = score;
        }
        int ans = 0;
        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    value[i][j] = Math.max(value[i][j], value[i][k] + value[k][j]);
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, value[i][j]);
            }
        }
        System.out.println(ans);
    }
}
