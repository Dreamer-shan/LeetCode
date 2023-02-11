//package 荣耀;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/08/10/20:08
// * @Description:
// */
//package 荣耀;
//
//import java.util.*;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/08/10/19:21
// * @Description:
// */
//public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        int n = sc.nextInt();
//        int[][] time = new int[n][2];
//        for (int i = 0; i < n; i++) {
//            time[i][0] = sc.nextInt();
//            time[i][1] = sc.nextInt();
//
//        }
//        Arrays.sort(time, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[0] == o2[0]) {
//                    return o1[1] - o2[1];
//                }
//                return o1[0] - o2[0];
//            }
//        });
//
//        Arrays.sort(time, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                if (o1[1] == o2[1]) {
//                    return o1[0] - o2[0];
//                }
//                return o1[1] - o2[1];
//            }
//        });
////        for (int[] ints : time) {
////            System.out.println(Arrays.toString(ints));
////        }
////        int temp = time[0][1];
////        int ans = 0;
////        for (int i = 1; i < n; i++) {
////            if (time[i][0] >= temp){
////                ans += time[i - 1][1] - time[i - 1][0];
////                temp = time[i][1];
////            }
////        }
////        System.out.println(ans);
//        int ans = 0;
//        int[] dp = new int[n];
//        for (int i = 0; i < n; i++) {
//            int max = 0;
//            for (int j = 0; j < i; j++) {
//                if (dp[j] > max && time[i][0] >= time[j][1]) {
//                    max = dp[j];
//                }
//            }
//            dp[i] = max + time[i][1] - time[i][0];
//            ans = Math.max(ans, dp[i]);
//        }
//        System.out.println(ans);
////        System.out.println(ans);
////        System.out.println(time[n-1][1] - time[0][0]);
////        for (int[] ints : time) {
////            System.out.println(Arrays.toString(ints));
////        }
//
////        while (n-- > 0){
////            for (int i = 0; i < n; i++) {
////                time[i][0] = sc.nextInt();
////                time[i][1] = sc.nextInt();
////            }
////        }
//    }
//}
