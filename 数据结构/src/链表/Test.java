package 链表;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/04/20/8:57
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String caozuo = sc.next();
            if (caozuo.equals("Add")){
                String building = sc.nextLine();
                String[] s = building.split(" ");
                System.out.println("s[0]" + s[0]);
                System.out.println(s[1]);
                System.out.println(s[2]);
                map.put(s[0],new int[]{Integer.parseInt(s[1]), Integer.parseInt(s[2])});
            }else if (caozuo.equals("Delete")){
                String building = sc.next();
                map.remove(building);
            }else if (caozuo.equals("Change")){
                String building = sc.next();
                String[] s = building.split(" ");
                if (map.containsKey(s[0])){
                    map.put(s[0],new int[]{Integer.parseInt(s[1]), Integer.parseInt(s[2])});
                }


            }else if (caozuo.equals("Query")){
                String s = sc.next();
                if (map.containsKey(s)){
                    System.out.println("yes");
                    System.out.println(map.get(s));
                }else {
                    System.out.println("no");
                }
            }
        }
    }
}
