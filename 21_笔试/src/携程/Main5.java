package 携程;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/09/20:26
 * @Description:
 */
public class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        String n = sc.nextLine();
        for (int i = 0; i < Integer.valueOf(n); i++) {
            String str = sc.nextLine();
            if (!(str.startsWith("cd") || str.startsWith("pwd"))) continue;
            list.add(str.trim());
        }
        Deque<String> q = new ArrayDeque<>();
        for (String s : list) {
            if (s.equals("pwd")){
                help(q);
            }else {
                String[] temp = s.split(" ");
                String path = temp[1];
                if (path.equals("..")){
                    if (q.size() != 0){
                        q.removeLast();
                    }
                }else {
                    q.addLast(path);
                }
            }
        }
    }

    private static void help(Deque<String> q) {
        Iterator<String> iterator = q.iterator();
        if (q.size() == 0){
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
