import java.util.*;

/**
 * @author Shan
 * @Description
 * @create 2021-08-01 16:14
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        str = str.replace("[","").replace("]","");
        String[] split = str.split(",");

        int[] arr = new int[split.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.valueOf(split[i]);
        }

        int[] help = help(arr);
        System.out.println(Arrays.toString(help));
    }
    public static int[] help(int[] rains){
        int[] res = new int[rains.length];
        Arrays.fill(res, 1);
        Map<Integer, Integer> map = new HashMap<>();
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < rains.length; i++) {
            int rain = rains[i];
            if (rain == 0){
                set.add(i);
                continue;
            }
            if (map.containsKey(rain)){
                Integer r = set.higher(map.get(rain));
                if (r == null){
                    return new int[0];
                }
                res[r] = rain;
                set.remove(r);
            }
            map.put(rain, i);
            res[i] = -1;
        }
        return res;
    }
}
