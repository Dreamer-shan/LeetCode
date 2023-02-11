package 美团;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/04/16:13
 * @Description:
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        Map<Integer, List<Integer>> map = new HashMap<>();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) res[i][j] = 0;
            }
        }
        int i = 1;
        int line = n;
        while (line-- > 0){
            int t = sc.nextInt();
            while (t-- >0){
                ArrayList<Integer> list = new ArrayList<>();
                int index = sc.nextInt();
                list.add(index);
                map.put(i, list);
            }
            i++;
        }
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            System.out.println(entry.getKey()+ ""+ map.values());
        }
    }
}

