import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Shan
 * @Description
 * @create 2021-04-18 19:59
 */
public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int len = 2 * n;
        String[] str = new String[len];
        for (int i = 0; i < len; i++) {
            str[i] = sc.next();
        }
        for (int i = 0; i < len; i = i + 2) {
            boolean flag = helper(i, str);
            if (flag == true){
                System.out.println("YES");
            }else {
                System.out.println("NO");
            }
        }
    }

    private static boolean helper(int i, String[] str) {
        String a = str[i];
        String b = str[i + 1];
        boolean flag = false;
        int len = a.length();
        if (len % 2 == 0){
            flag = ou(a, b);
        }else {
            flag = ji(a, b);
        }
        return flag;
    }

    private static boolean ji(String a, String b) {
        return a.equals(b);
    }
    private static boolean ou(String a, String b) {

        int len = a.length();
        boolean flag = false;
        if (len < 2){
            return a.equals(b);
        }
        if (len % 2 != 0){
            return ji(a, b);
        }
        int mid = len / 2;
        String a1 = a.substring(0, mid);
        String a2 = a.substring(mid + 1, len);
        String b1 = a.substring(0, mid);
        String b2 = a.substring(mid + 1, len);
        flag = ((ou(a1,b1)&&ou(a2,b2)) ||ou(a1,b2)&&ou(a2,b1));
        return flag;
    }
}
