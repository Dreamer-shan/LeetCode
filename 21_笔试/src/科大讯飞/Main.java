package 科大讯飞;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/28/19:40
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String[] strs = sc.nextLine().split(" ");
        for (int i = 0; i < strs.length; i++) {
            list.add(Integer.valueOf(strs[i]));
        }
        int n = sc.nextInt();
        int index = list.indexOf(n) + 1;
        if (index >= 1 && index <= 5){
            System.out.println("A+");
        }else if (index >= 6 && index <= 15){
            System.out.println("A0");
        }else if (index >= 16 && index <= 30){
            System.out.println("B+");
        }else if (index >= 31 && index <= 35){
            System.out.println("B0");
        }else if (index >= 36 && index <= 45){
            System.out.println("C+");
        }else if (index >= 46 && index <= 48){
            System.out.println("C0");
        }else if (index >= 49 && index <= 50){
            System.out.println("F");
        }
    }
}
