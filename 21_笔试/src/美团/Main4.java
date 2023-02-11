package 美团;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/04/16:13
 * @Description:
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        char[] chars = str.toCharArray();
        int num = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            char c = str.charAt(i + 1);
            int preIndex = i;
            if (c == 'c'){
                while (preIndex >= 0 && chars[preIndex] == 'a'){
                    chars[preIndex + 1] = chars[preIndex];
                    preIndex--;
                    num++;
                }
                chars[preIndex + 1] = c;
            }

        }
        System.out.println(num);

    }


}
