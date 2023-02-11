import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shan
 * @Description
 * @create 2021-08-08 10:46
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str = s.replaceAll(" ", "");
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (s.indexOf(c) == str.lastIndexOf(c)) {// 此字符第一次位置和最后位置一致
                sb.append(c); // 即肯定没有重复的直接添加
            } else {// 同理 次字符出现过多次
                int number = str.indexOf(c);// 次字符第一次出现的位置
                if (number == i) {// 第一次出现的位置和当前位置一致 即第一次出现添加
                    sb.append(c);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
//        while (fast < chars.length) {
//            if (chars[slow] == chars[fast]){
//                chars[slow] = chars[fast];
//                fast++;
//            }else {
//                slow++;
//                fast++;
//            }
//        }


//public class Test {
//
//    public static void main(String[] args) {
////        String str = "aabbbccccdddddeeeeeeeeefff234tttdddfffbbbggg";
//        String str = "a iC C   C G m yyyySp  p";
//        removeMethod(str);
//    }
//
//    public static void removeMethod(String s) {
//        System.out.println("去重前----:" + s);
//        StringBuffer bu = new StringBuffer();
//        int len = s.length();
//        for (int i = 0; i < len; i++) {
//            char c = s.charAt(i);
//            if (s.indexOf(c) == s.lastIndexOf(c)) {// 此字符第一次位置和最后位置一致
//                bu.append(c); // 即肯定没有重复的直接添加
//            } else {// 同理 次字符出现过多次
//                int number = s.indexOf(c);// 次字符第一次出现的位置
//                if (number == i) {// 第一次出现的位置和当前位置一致 即第一次出现添加
//                    bu.append(c);
//                }
//            }
//        }
//        System.out.println("去重后----:" + bu.toString());
//    }
//}