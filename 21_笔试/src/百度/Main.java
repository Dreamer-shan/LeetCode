package 百度;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/28/20:21
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String strs = sc.nextLine();
        int i = 0, j = 0;
        int n = strs.length();
        for (int k = 0; k < n; k++) {
            char ch = strs.charAt(k);
            if (ch == 'L'){
                i--;
            }else if (ch == 'R'){
                i++;
            }else if (ch == 'U'){
                j++;
            }else if (ch == 'D'){
                j--;
            }
        }
        System.out.println("("+i+","+j+")");
    }
}
