package 网易;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/21/15:26
 * @Description:
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        long[] ageArr = new long[strs.length];
        for (int i = 0; i < strs.length; i++) {
            ageArr[i] = Integer.valueOf(strs[i]);
        }
//        System.out.println(Arrays.toString(ageArr));
        int n = strs.length;
        long count = 1;
        long cur = 1;
        long pre = 1;
        long dec = 0;
        for (int i = 1; i < n; i++) {
            if (ageArr[i] >= ageArr[i - 1]) {
                dec = 0;
                pre = ageArr[i] == ageArr[i - 1] ? 1 : pre + 1;
                count += pre;
                cur = pre;
            } else {
                dec++;
                if (dec == cur) {
                    dec++;
                }
                count += dec;
                pre = 1;
            }

        }
        System.out.println(count);
    }
}
