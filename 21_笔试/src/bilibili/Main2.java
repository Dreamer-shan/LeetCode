//package bilibili;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/09/13/19:19
// * @Description:
// */
//import java.io.*;
//import java.util.*;
//import java.text.*;
//import java.math.*;
//import java.util.regex.*;
//
//class Solution {
//    /* Write Code Here */
//    public int[] GetSortedTasks(int[][] taskLists) {
//        int m = taskLists.length, n = taskLists[0].length;
//        int[] res = taskLists[0];
//        for (int i = 1; i < taskLists.length; i++) {
//            res = mergeTwoArr(res, taskLists[i]);
////            System.out.println(Arrays.toString(res));
//        }
////        System.out.println("sss"+res.length);
//        return res;
//    }
//    public int[] mergeTwoArr(int[] arr1, int[] arr2){
//        int p1 = 0, p2 = 0, index = 0;
//        int[] res = new int[arr1.length + arr2.length];
//        while (p1 < arr1.length && p2 < arr2.length){
//            if (arr1[p1] <= arr2[p2]){
//                res[index++] = arr1[p1++];
//            }else {
//                res[index++] = arr2[p2++];
//            }
//        }
//        while (p1 < arr1.length){
//            res[index++] = arr1[p1++];
//        }
//        while (p2 < arr2.length){
//            res[index++] = arr2[p2++];
//        }
//        return res;
//    }
//
//}
//
//public class Main2 {
//    public static void main(String[] args){
//        Scanner in = new Scanner(System.in);
//        int[] res;
//
//        int _taskLists_rows = 0;
//        int _taskLists_cols = 0;
//        _taskLists_rows = Integer.parseInt(in.nextLine().trim());
//        _taskLists_cols = Integer.parseInt(in.nextLine().trim());
//
//        int[][] _taskLists = new int[_taskLists_rows][_taskLists_cols];
//        for(int _taskLists_i=0; _taskLists_i<_taskLists_rows; _taskLists_i++) {
//            for(int _taskLists_j=0; _taskLists_j<_taskLists_cols; _taskLists_j++) {
//                _taskLists[_taskLists_i][_taskLists_j] = in.nextInt();
//
//            }
//        }
//
//        if(in.hasNextLine()) {
//            in.nextLine();
//        }
//
//        res = new Solution().GetSortedTasks(_taskLists);
//        for(int res_i=0; res_i < res.length; res_i++) {
//            System.out.println(String.valueOf(res[res_i]));
//        }
//    }
//}
