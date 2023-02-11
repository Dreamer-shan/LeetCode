import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author Shan
 * @Description
 * @create 2021-08-08 11:20
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int count = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n / 2; i++) {
            if (!set.contains(arr[i]) && arr[i] != arr[i + n / 2]){
                count++;
                set.add(arr[i]);
            }
        }
        System.out.println(count);
    }
}
