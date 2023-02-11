//package 网易;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/08/21/15:11
// * @Description:
// */
//
//
//public class Solution1 {
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
//
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
//
////    public static void main(String[] args) {
////        String aa = "abcxyz";
////        System.out.println(reverse(aa));
////        char[] invert = invert(aa);
////        System.out.println(Arrays.toString(invert));
////    }
//}