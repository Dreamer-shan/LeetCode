package 网易;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/21/14:34
 * @Description:
 */
public class Main1 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int[] arr = new int[strs.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        int M = sc.nextInt();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] <= M){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
