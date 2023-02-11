package 美团;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/04/16:13
 * @Description:
 */
public class Main8 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        String[] strs = sc.nextLine().trim().split(" ");
        int n = strs.length;
        String[] arr = new String[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = strs[i - 1];
        }
        int m = sc.nextInt();
        int total = sc.nextInt();
        int index = m;
        int count = 0;
        for (int i = 0; i < total; i++) {
            if (index == n + 1 || i == n + 1) break;
            if (i == total) {
                System.out.print(arr[index]);
            }
            else{
                if (i != 0 && count % 20 == 0){
                    System.out.print(arr[index]);
                }else {
                    System.out.print(arr[index]+";");
                }

            }
            index++;
            count++;
            if (count % 20 == 0) System.out.println();

        }
//        System.out.println(Arrays.toString(arr));


    }


}
