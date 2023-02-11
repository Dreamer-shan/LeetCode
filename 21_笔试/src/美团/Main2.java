package 美团;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/04/16:39
 * @Description:
 */
public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        char[] chars = sc.next().toCharArray();
        String chars = sc.next();
        int num = 0;
        Deque<Character> q1 = new LinkedList<>();
        Deque<Character> q2 = new LinkedList<>();
        for (int i = 0; i < chars.length(); i++) {
            char c = chars.charAt(i);
            if (c == 'c'){
                while (!q1.isEmpty()){
                    if (q1.peekLast() == 'a'){
                        q2.addLast(q1.pollLast());
                        num++;
                    }else {
                        break;
                    }
                }
                while (!q2.isEmpty()){
                    q1.addLast(q2.pollLast());
                }
            }else {
                q1.addLast(c);
            }
        }
//        for (char c : chars) {
//            if (c == 'c'){
//                while (!q1.isEmpty()){
//                    if (q1.peekLast() == 'a'){
//                        q2.addLast(q1.pollLast());
//                        num++;
//                    }else {
//                        break;
//                    }
//                }
//                while (!q2.isEmpty()){
//                    q1.addLast(q2.pollLast());
//                }
//            }else {
//                q1.addLast(c);
//            }
//        }
        System.out.println(num);
    }
}
