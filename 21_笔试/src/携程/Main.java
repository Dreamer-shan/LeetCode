//package 携程;
//
//import java.util.Arrays;
//import java.util.Scanner;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/09/09/19:02
// * @Description:
// */
//public class Main {
//    static int max = 10000          0;
//    static int[][] state = new int[max][max];
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int k = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        System.out.println(sum(n, k, arr));
////        System.out.println(Arrays.toString(arr));
//
//    }
//
//    static int sum(int n, int m, int[] arr){
//        int i, temp = 0, max;
//        for (i = 1; i <= n; i++) {
//            state[i][1] = state[i-1][1] + arr[i];
//        }
//        for (int j = 2; j <= m; j++) {
//            for (i = j; i <= n; i++) {
//                temp = 1000000;
//                for (int k = j; k < i; k++) {
//                    max = Math.max(state[i][1] - state[k][1], state[k][j-1]);
//                    if (temp > max) temp = max;
//                }
//            }
//            state[i][j] = temp;
//
//        }
//        return state[n][m];
//    }
//}
