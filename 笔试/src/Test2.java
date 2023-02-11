import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Shan
 * @Description
 * @create 2021-07-28 17:41
 */
public class Test2 {
    public static void main(String[] args) {
        ArrayList<Integer> ans = help();
        System.out.println(ans);
    }
    public static ArrayList<Integer> help(){
        ArrayList<Integer> ans = new ArrayList<>();
        int n = 1;
        while(n < 1000){
            for (int i = 2; i < n; i++) {
                if (n % i != 0 && help2(n)){
                    ans.add(n);
                }
            }

            n++;
        }
        return ans;
    }
    public static boolean help2(int n){
        int a = n % 10;
        int b = n / 10 % 10;
        int c = n / 100;
        if ((a + b + c) % 2 == 0){
            return true;
        }
        return false;
    }
//    Integer
}
