
import java.util.*;

/**
 * @author Shan
 * @Description
 * @create 2021-04-24 13:59
 */
public class Solution5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int q = sc.nextInt();
        for (int j = 1; j <= n1; j++) {
            list1.add(j);
        }
        for (int j = n1 + 1; j <= n1 + n2; j++) {
            list2.add(j);
        }
        for (int i = 0; i < q; i++) {
            int a = sc.nextInt();
            if (list1.contains(a)){
                list2.addLast(a);
                list1.remove(new Integer(a));
            }else if (list2.contains(a)){
                list1.addLast(a);
                list2.remove(new Integer(a));
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            if (i  == list1.size() - 1){
                System.out.print(list1.get(i));
            }else{
                System.out.print(list1.get(i) + " ");
            }
        }
        System.out.println();
        for (int i = 0; i < list2.size(); i++) {
            if (i  == list2.size() - 1){
                System.out.print(list2.get(i));
            }else{
                System.out.print(list2.get(i) + " ");
            }
        }
//        System.out.println(Arrays.toString(list2));
    }
}