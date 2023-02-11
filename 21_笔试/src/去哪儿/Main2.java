package 去哪儿;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/14/19:42
 * @Description:
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

class Solution {
    /* Write Code Here */
    public String solution(int[] d) {

        int n = d.length;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < d.length; i++) {
            arr[i++] = d[i++];
        }
        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= i; j--) {
                int num = help(arr, i, j);
                if (num % 3 == 0){
                    max = Math.max(max, num);
                    return String.valueOf(max);
                }
            }
        }
        return "";
    }

    private int help(Integer[] arr, int i, int j) {
        StringBuilder sb = new StringBuilder();
        for (int k = i; k <= j; k++) {
            sb.append(arr[k]);
        }
        return Integer.parseInt(sb.toString());
    }


}

public class Main2 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        int _d_size = 0;
        _d_size = Integer.parseInt(in.nextLine().trim());
        int[] _d = new int[_d_size];
        int _d_item;
        for(int _d_i = 0; _d_i < _d_size; _d_i++) {
            _d_item = Integer.parseInt(in.nextLine().trim());
            _d[_d_i] = _d_item;
        }

        res = new Solution().solution(_d);
        System.out.println(res);
    }
}
