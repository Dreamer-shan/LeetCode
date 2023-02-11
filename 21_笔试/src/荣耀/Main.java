package 荣耀;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/10/20:28
 * @Description:
 */
//        1
//        6
//        15 17
//        8 11
//        10 16
//        11 12
//        13 15
//        9 12
//    输出8
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int c = 0; c < T; c++) {
            int n = sc.nextInt();
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int time0 = sc.nextInt();
                int time1 = sc.nextInt();
                if (!map.containsKey(time1)){
                    map.put(time1, new ArrayList<>());
                }
                map.get(time1).add(time0);
            }
            int[] nums = new int[24];
            for (int i = 9; i < 24; i++) {
                if (map.containsKey(i)){
                    List<Integer> time_list = map.get(i);
                    for (int j = 0; j < time_list.size(); j++) {
                        int time0 = time_list.get(j);
                        if (nums[time0] + (i - time0) > nums[i]){
                            nums[i] = nums[time0] + i - time0;
                        }
                    }
                }else {
                    nums[i] = nums[i-1];
                }
            }
            int max = 0;
            for (int i = 9; i < 24; i++) {
                if (nums[i] > max){
                    max = nums[i];
                }
            }
            System.out.println(max);
        }

    }
}


//public class Main1 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int T = sc.nextInt();
//        for (int t = 0; t < T; t++) {
//            Map<Integer, List<int[]>> map = new HashMap<>();
//            int n = sc.nextInt();
//            int index = sc.nextInt();
//            int n_friend = sc.nextInt();
//            int k = sc.nextInt();
//            for (int i = 0; i < k; i++) {
//                int a1 = sc.nextInt();
//                int a2 = sc.nextInt();
//                int a3 = sc.nextInt();
//                if (!map.containsKey(a1)){
//                    map.put(a1, new ArrayList<>());
//                }
//                if (!map.containsKey(a2)){
//                    map.put(a2, new ArrayList<>());
//                }
//                int[] nums = new int[3];
//                nums[0] = a2;
//                nums[1] = 1;
//                nums[2] = a3;
//                map.get(a1).add(nums);
//                nums = new int[3];
//                nums[0] = a1;
//                nums[1] = 1;
//                nums[2] = a3;
//                map.get(a1).add(nums);
//            }
//            Set<Integer> set = new HashSet<>();
//            set.add(index);
//            Queue<int[]> queue = new LinkedList<>();
//            queue.add(new int[]{index, 0});
//            for (int i = 0; i < n_friend; i++) {
//                int number = queue.size();
//                for (int j = 0; j < number; j++) {
//                    int[] item = queue.poll();
//                    if (map.containsKey(item[0])){
//                        List<int[]> lists = map.get(item[0]);
//                        for (int c = 0; c < lists.size(); c++) {
//                            int[] item_num = lists.get(c);
//                            if (!set.contains(item_num[0])){
//                                queue.add(new int[]{item_num[0], item[1] + item_num[2]});
//                            }
//                        }
//                    }
//                }
//            }
//            if (queue.size() == 0) System.out.println("-1");
//            else {
//                int[][] all =
//            }
//        }
//    }
//}


//2
//        10 5 2
//        13 0 3 5 0 4 9 0 6 8 0 7 5 1 2 6 1 6 3 2 9 7 3 4 3 3 5 3 3 8 3 3 9 3 5 8 9 7 8 9
//        10 0 2
//        13 0 3 5 0 4 9 0 6 8 0 7 5 1 2 6 1 6 3 2 9 7 3 4 3 3 5 3 3 8 3 3 9 3 5 8 9 7 8 9

//7 0 4 9
//        1 5 8 9