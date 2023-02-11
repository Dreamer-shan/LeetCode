package 网易;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/21/16:33
 * @Description:
 */
public class Main5 {
    public static char findKthBit(int n, int k) {
        // write code here
        String S = "a";
        for (int i = 1; i < n; i++) {
            char temp = (char) ('a' + i);
            String s1 = S;
            String rev_inv  = res_invert(S);
            S = s1 + temp;
            S += rev_inv;
        }
        char res = S.charAt(k-1);
        return res;
    }

    public static String res_invert(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) ('z' - (charArray[i] - 'a'));
        }

        StringBuilder sb = new StringBuilder(charArray.toString());
//        System.out.println(sb.toString());
        String s = sb.reverse().toString();
        System.out.println(s);
//        System.out.println(sb.reverse());
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        char kthBit = findKthBit(4,11);
//        System.out.println(kthBit);
        String aaa = "Aaaa";
        System.out.println(aaa);

    }
}


//import java.util.*;
//
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * 返回Sn的第k位字符
//     * @param n int整型 Sn的n
//     * @param k int整型 需要返回的字符下标位
//     * @return char字符型
//     */
//    static long[] num;
//    public static char findKthBit (int n, int k) {
//        // write code here
//        num = new long[26];
//        int index = 0;
//        num[0] = 1;
//        for (int i = 0; i < 25; i++) {
//            num[i + 1] = num[i] * 2 + 1;
//            if (k > num[i] && k < num[i+1]){
//                index = i+1;
//                break;
//            }
//        }
//        return help(k, index);
//    }
//    public static char help(int k, int index){
//        if (k == 1) return 'a';
//        if (num[index] + 1 == 2 * k)    return (char) ('a' + index);
//        long item = num[index] - k + 1;
//        for (int i = 0; i < 25; i++) {
//            if (item > num[i] && item <= num[i+1]){
//                index = i + 1;
//                break;
//            }
//        }
//        return help(k, index);
//    }
//    public static String reverse(String str){
//        StringBuilder sb = new StringBuilder(str);
//        return sb.reverse().toString();
//    }
//
//    public static char[] invert(String s){
//        char[] str = s.toCharArray();
//        for (int i = 0; i < str.length; i++) {
//            if (str[i] >= 65 && str[i] <= 90){
//                str[i] = (char) (155 - str[i]);
//            }else if (str[i] >= 97 && str[i] <= 122){
//                str[i] = (char) (219 - str[i]);
//            }else {
//                continue;
//            }
//        }
//        return str;
//    }
//}