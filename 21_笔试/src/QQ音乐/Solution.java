//package QQ音乐;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/09/16/19:03
// * @Description:
// */
//
//
//public class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     *
//     * @param n int整型
//     * @param k int整型
//     * @return long长整型
//     */
//    public static void main(String[] args) {
////        System.out.println(convert(4, 2));
////        System.out.println(convert(8, 2));
////        System.out.println(convert(33, 2));
////        System.out.println(convert(1, 3));
////        System.out.println(convert(2, 3));
////        System.out.println(convert(3, 3));
////        System.out.println(convert(4, 3));
////        System.out.println(convert(5, 3));
////        System.out.println(number1(convert(1,3)));
////        System.out.println(number1(convert(2,3)));
////        System.out.println(number1(convert(3,3)));
////        System.out.println(number1(convert(4,3)));
////        System.out.println(number1(convert(5,3)));
//        minM(5,3);
//        minM(10,10);
//    }
//    public static long minM (int n, int k) {
//        // write code here
//        int m = 1;
//        int f = 0;
//        while (f < n){
//            f += number1(convert(m, k));
//            m++;
//        }
//        System.out.println(m - 1);
//        return m - 1;
//
//    }
//    public static String convert(int n, int k){
//        String res = "";
//        while (n != 0){
//            int temp = n % k;
//            res += temp;
//            n = n / k;
//        }
//        StringBuilder sb = new StringBuilder(res);
//        return sb.reverse().toString();
//    }
//    public static int number1(String str){
//        char[] chars = str.toCharArray();
//        int count = 0;
//        for (int i = 0; i < chars.length; i++) {
//            if (chars[i] == '1'){
//                count++;
//            }
//        }
//        return count;
//    }
//}