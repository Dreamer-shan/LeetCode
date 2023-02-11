package 小米;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/01/20:13
 * @Description:
 */
//public class Main2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int i = fun(n, 3);
//        System.out.println(i+1);
//    }
//
//    public static int fun(int m, int k){
//        if (m <= 0 || k <= 0){
//            System.out.println("error");
//            return -1;
//        }else {
//            if (m == 1){
//                return 0;
//            }else {
//                return ((fun(m - 1, k) + k) % m);
//            }
//        }
//    }
//}

class Main2 {
    public static String reverseWords(String s) {
        String[] strings = s.trim().split(" ");

        StringBuilder sb = new StringBuilder();
        for (int i = strings.length - 1; i >= 0; i--) {
            if (strings[i].equals("")) continue;    // 碰到空单词，跳过。 空单词是"" 而不是" "
            sb.append(strings[i] + " ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s = "a good   example";
        System.out.println(reverseWords(s));
    }
}