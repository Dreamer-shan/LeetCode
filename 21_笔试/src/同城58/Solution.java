package 同城58;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/11/20:28
 * @Description:
 */
import java.util.*;


public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,1,4,7,7};
        int[] ints = find(arr);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] find (int[] arg) {
        // write code here
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i : arg) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1){
                list.add(key);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}