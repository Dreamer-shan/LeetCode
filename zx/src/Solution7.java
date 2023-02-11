import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Shan
 * @Description
 * @create 2021-04-24 13:59
 */
public class Solution7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int count = 0;
        int len = 0;
        int i = 0;
        int distance = t - s;
        if (distance <= 0){
            System.out.println(0);
        }else if (distance > Math.pow(2, count)){
            if (count % 2 == 0){
                distance += Math.pow(2, len);
                count++;
                len = -len;
            }else {
                distance -= Math.pow(2, len);
                count++;
                len = -len;
            }
            len = Math.abs(len) + 1;
        }
    }
}