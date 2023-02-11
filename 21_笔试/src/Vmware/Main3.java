package Vmware;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/18/19:39
 * @Description:
 */
public class Main3 {
    static int max = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] value = new int[m][m];
//        System.out.println(m);
//        System.out.println(n);
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int row = sc.nextInt();
            int col = sc.nextInt();
            int score = sc.nextInt();
            if (!map.containsKey(row))  map.put(row, new HashMap<>());
            if (!map.containsKey(col))  map.put(col, new HashMap<>());
            map.get(row).put(col, score);
            map.get(col).put(row, score);
        }
        boolean[] path = new boolean[n + 1];
        path[1] = true;
        dfs(0, map, 1, path);
        System.out.println(max);
    }

    private static void dfs(int len, Map<Integer, Map<Integer, Integer>> map, int i, boolean[] path) {
        int item = 0;
        Map<Integer, Integer> map1 = map.get(i);
        for (Integer key : map1.keySet()) {
            if (path[key] == false){
                path[key] = true;
                dfs(len + map1.get(key), map, key, path);
                path[key] = false;
                item++;
            }
        }
        if (item == 0){
            if (len > max)  max = len;
        }

    }
}
