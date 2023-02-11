package 科大讯飞;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/28/20:36
 * @Description:
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0){
            int x = sc.nextInt();
            int st = sc.nextInt();
            if (x-st >0 && x+ st < 60){
                System.out.println(1);
            }
            while (st-- > 0){

            }
        }
    }
}
