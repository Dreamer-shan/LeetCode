package 爱奇艺;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/12/16:06
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            if (!map.containsKey(digitSum(i))){
                map.put(digitSum(i), 1);
            }else {
                map.put(digitSum(i), map.get(digitSum(i)) + 1);
            }
        }
        int max = 0;
        int count = 0;
        for (Integer value : map.values()) {
            max = Math.max(max, value);
        }
        for (Integer value : map.values()) {
            if (value == max){
                count++;
            }
        }
//        for(int auto : map.values()){
//            if (auto > max){
//                max = auto;
//            }
//        }
//        for(int auto : map.values()){
//            if (max == auto){
//                res++;
//            }
//        }




        System.out.println(count);
    }

    public static int digitSum(int n){
        int sum = 0;
        while (n != 0){
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
