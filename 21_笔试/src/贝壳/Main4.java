package 贝壳;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/03/18:01
 * @Description:
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
            int l = 0, r = arr.length - 1, count = 0;
//            if (arr.length == 2){
//                System.out.println(1);
//                continue;
//            }else if (arr.length == 3){
//                System.out.println(0);
//                continue;
//            }
            while (l < r){
                int sum = arr[l] + arr[r];
                l++;
                r--;
                int sum2 = arr[l] + arr[r];
                if (sum == sum2)    count++;
            }
            System.out.println(count);
//            System.out.println(Arrays.toString(arr));
        }

//        Scanner sc = new Scanner(System.in);
//
//        int T = sc.nextInt();
//        while (T-- > 0){
//            int n = sc.nextInt();
//            int[] arr = new int[n];
//            for (int i = 0; i < arr.length; i++) {
//                arr[i] = i + 1;
//            }
//            int count = 0;
//            Map<Integer, Integer> map = new HashMap<>();
//
//            map.put(0, 1);
//            for (int i = 1; i <= arr.length; i++) {
//                map.put(i, 1);
//            }
//            int target = n;
//            for (int i = 0; i < n; i++) {
//                if (map.containsKey(target - map.get(n))){
//                    count++;
//                }
//            }
//            System.out.println(count);
//            System.out.println(Arrays.toString(arr));
//        }
    }
}
