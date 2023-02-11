package 携程;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/09/20:47
 * @Description:
 */
public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < Integer.valueOf(n); i++) {
            String s = sc.nextLine();
            if (!(s.startsWith("cd") || s.startsWith("pwd"))){
                continue;
            }
            arrayList.add(s.trim());
        }
        Deque<String> deque = new ArrayDeque<>();
        for (String s : arrayList) {
            if ("pwd".equals(s)){
                fun(deque);
            }else {
                String[] s1 = s.split(" ");
                String path = s1[1];
                if (path.equals("..")){
                    if (deque.size() != 0){
                        deque.removeLast();
                    }
                }else {
                    deque.addLast(path);
                }
            }
        }
    }

    private static void fun(Deque<String> deque) {
        Iterator<String> iterator = deque.iterator();
        if (deque.size() == 0){
            System.out.println("\\");
        }
        StringBuilder sb = new StringBuilder();
        while (iterator.hasNext()){
            String next = iterator.next();
            sb.append("\\" + next);
        }
        System.out.println(sb.toString());
    }
}
