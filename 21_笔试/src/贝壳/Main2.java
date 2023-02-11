package 贝壳;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/03/18:59
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            String strs = sc.next();
//            char[] charArray = strs.toCharArray();
            int ans = fun(strs);
            System.out.println(ans);
        }
    }

    private static int fun(String strs) {
        char[] charArray = strs.toCharArray();
        int count = 0, num = 0;
        int n = charArray.length;
        for (int i = 0; i < n; i++) {
            if (charArray[i] == '('){
                num++;
            }else {
                if (num == 0){
                    count++;
                }else {
                    num--;
                }
            }
        }
        return count;
    }
}
