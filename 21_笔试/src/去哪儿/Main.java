//package 去哪儿;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/09/14/18:39
// * @Description:
// */
//class Solution {
//    /* Write Code Here */
//    public int solution(int[] arr) {
//        int n = arr.length;
//        Arrays.sort(arr);
//        if (arr[n - 1] < 0)    return 0;
//        int temp = arr[n - 1];
//        int end= arr[n - 1];
//        for (int i = n - 2; i >= 0; i--) {
//            if (arr[i] + temp > 0){
//                temp += arr[i];
//                end += temp;
//            }else {
//                break;
//            }
//        }
//        return end;
//    }
//}
//
//public class Main {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int res;
//
//        int _arr_size = 0;
//        _arr_size = Integer.parseInt(in.nextLine().trim());
//        int[] _arr = new int[_arr_size];
//        int _arr_item;
//        for (int _arr_i = 0; _arr_i < _arr_size; _arr_i++) {
//            _arr_item = Integer.parseInt(in.nextLine().trim());
//            _arr[_arr_i] = _arr_item;
//        }
//
//        res = new Solution().solution(_arr);
//        System.out.println(String.valueOf(res));
//
//    }
//}