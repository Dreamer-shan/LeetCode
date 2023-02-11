package 荣耀;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/10/19:21
 * @Description:
 */


import java.util.*;

//public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        int n = sc.nextInt();
//        int[][] time = new int[n][2];
//        while(T-->0){
//            for (int i = 0; i < n; i++) {
//                time[i][0] = sc.nextInt();
//                time[i][1] = sc.nextInt();
//
//            }
//            Arrays.sort(time, new Comparator<int[]>() {
//                @Override
//                public int compare(int[] o1, int[] o2) {
//                    if (o1[0] == o2[0]){
//                        return o1[1] - o2[1];
//                    }
//                    return o1[0] - o2[0];
//                }
//            });
//            System.out.println(time[n-1][1] - time[0][0] - 1);
//        }
//
//    }
//}
//public class Main2 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//
//
//        for (int c = 0; c < T; c++) {
//            int n = sc.nextInt();
//            Map<Integer, List<Integer>> map = new HashMap<>();
//            for (int i = 0; i < n; i++) {
//                int time0 = sc.nextInt();
//                int time1 = sc.nextInt();
//                if (!map.containsKey(time1)){
//                    map.put(time1, new ArrayList<>());
//                }
//                map.get(time1).add(time0);
////            }
//            int[] nums = new int[24];
//            for (int i = 9; i < 24; i++) {
//                if (map.containsKey(i)){
//                    List<Integer> time_list = map.get(i);
//                    for (int j = 0; j < time_list.size(); j++) {
//                        int time0 = time_list.get(j);
//                        if (nums[time0] + (i - time0) > nums[i]){
//                            nums[i] = nums[time0] + i - time0;
//                        }
//                    }
//                }else {
//                    nums[i] = nums[i-1];
//                }
//            }
//            int max = 0;
//            for (int i = 9; i < 24; i++) {
//                if (nums[i] > max){
//                    max = nums[i];
//                }
//            }
//            System.out.println(max);
//        }
//
//    }
//}
