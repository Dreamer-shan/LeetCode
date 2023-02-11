import java.util.*;

/**
 * @author Shan
 * @Description
 * @create 2021-04-24 13:59
 */
public class Solution6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> set1 = new LinkedHashSet<>();
        Set<Integer> set2 = new LinkedHashSet<>();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int q = sc.nextInt();
        for (int j = 1; j <= n1; j++) {
            set1.add(j);
        }
        for (int j = n1 + 1; j <= n1 + n2; j++) {
            set2.add(j);
        }


        for (int i = 0; i < q; i++) {
            int temp = sc.nextInt();
            if (set1.contains(temp)){
                set1.remove(temp);
                set2.add(temp);
            }else {
                set2.remove(temp);
                set1.add(temp);
            }
        }
        int index = 0;
        for (Integer integer : set1) {
            if (index == 0){
                System.out.print(integer);
                index++;
            }else {
                System.out.print(" " + integer);
            }
        }
        System.out.println();
        index = 0;
        for (Integer integer : set2) {
            if (index == 0){
                System.out.print(integer);
                index++;
            }else {
                System.out.print(" " + integer);
            }
        }
    }
}