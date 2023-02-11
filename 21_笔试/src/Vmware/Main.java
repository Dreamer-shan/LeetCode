package Vmware;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/18/19:25
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int count = 0;
        for (int i = n; i <= m; i++) {
            if (sushu(i) && contains1(i)){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean sushu(int n){
        for (int i = 2; i < n; i++) {
            if (n % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean contains1(int n){
        int temp = 0;
        while (n > 0){
            temp = n % 10;
            n /= 10;
            if (temp == 1){
                return true;
            }
        }
        return false;
    }

}
