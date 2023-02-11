//package 百度;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Scanner;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/09/28/20:50
// * @Description:
// */
//public class Main2 {
//    static List<List<Integer>> res = new ArrayList<>();
//    static LinkedList<Integer> path = new LinkedList<>();
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//
//    }
//
//    public static int subsets(int[] nums, int n){
//        subsetFun(nums, 0);
//        int num = 0;
//        for (List<Integer> list : res) {
//            if (list.size() == n){
//                int sum = 0;
//                for (Integer val : list) {
//                    sum += val;
//                }
//                num if (sum % 2 == 0){
//                    num++;
//                }
//            }
//        }
//    }
//
//    private static void subsetFun(int[] nums, int index) {
//        res.add(new ArrayList<>(path));
//        if (index >= nums.length){
//            return;
//        }
//        for (int i = index; i < nums.length; i++) {
//            path.add(nums[i]);
////            subsetFun(s, i + 1);
//            path.removeLast();
//        }
//    }
//}
