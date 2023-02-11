//
//import java.util.*;
//
///**
// * @author Shan
// * @Description
// * @create 2021-04-24 13:59
// */
//public class Solution3 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        HashMap<Integer, Integer> map1 =new HashMap<>();
//        int n = sc.nextInt();
//        int[] mission = new int[n];
//        Set<Integer> set = new HashSet<>();
//        HashMap<Integer, Integer> map =new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            mission[i] = sc.nextInt();
//            map1.put(i, mission[i]);
//            set.add(mission[i]);
//            map.put(mission[i], map.getOrDefault(mission[i], 0) + 1);
//            if (set.size() == 5){
//                for (Integer set_value : set) {
//                    int temp = map.get(set_value) - 1;
//                    map.put(mission[i], temp);
//                }
//                set.clear();
//                for (int j = 0; j < 5; j++) {
//                    System.out.print(map.get(j));
//                    continue;
//                }
//            }else {
//                System.out.println(-1);
//            }
//        }
//        System.out.println(map);
//    }
//}
