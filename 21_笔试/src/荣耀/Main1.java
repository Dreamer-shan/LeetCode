package 荣耀;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/10/18:50
 * @Description:
 */
//8 1 2 3 4 5 6 A
public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            if ("".equals(str)){
                continue;
            }
            String[] strs = str.split(" ");
            ArrayList<String> list = new ArrayList<>();
            int len = Integer.parseInt(strs[0]);
            for (int i = 1; i < strs.length; i++) {
                if (strs[i].equalsIgnoreCase("A")){
                    list.add("12");
                    list.add("34");
                }else if (strs[i].equalsIgnoreCase("B")){
                    list.add("AB");
                    list.add("CD");
                }else {
                    list.add(strs[i]);
                }
            }
//            list.add(0, Integer.toHexString(list.size() + 1).toUpperCase());
            list.add(0,String.valueOf(list.size()+1));
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()){
                System.out.print(iterator.next() + " ");
            }
        }
    }
}
