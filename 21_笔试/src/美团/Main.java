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
public class Main {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 2) System.out.println(0);
//        String str = "aba";
//        System.out.println(str.contains("aba"));
        char[] chars = {'a','b','a'};
        permutal(chars, 0, 2);
        int count = 0;
        for (String s : list) {
            if (s.contains("aba") || s.contains("bab")){
                continue;
            }
            count++;
        }
        System.out.println(count + 2);

    }

    public static void permutal(char[] chars, int from, int to){

        if (to <= 1)    return;
        if (from == to) list.add(String.valueOf(chars));
        else {
            for (int i = from; i <= to ; i++) {
                swap(chars, i, from);
                permutal(chars, from + 1, to);
                swap(chars, from, i);
            }
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }
}
