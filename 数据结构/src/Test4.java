import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/23/12:12
 * @Description:
 */
//(a(4)b(5))(4)
public class Test4 {
    public static void main(String[] args) {
        String s = "a(4)";
        System.out.println(fun(s));

    }
    public static String fun(String s){
        Stack<Character> stack = new Stack<>();
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int index = 0;
        int n = s.length();
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
           map.put(s.charAt(i), i);
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' && map.containsKey(s.charAt(i-1))){
                index++;
                stack.push('(');
                num = Integer.valueOf(s.charAt(i));
            }else if (ch == ')'){
                for (int j = 0; j < num; j++) {
                    sb.append(s.charAt(index - 3));
                }
                stack.pop();
            }
        }
        return sb.toString();
    }
}
