package haluo;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/02/19:49
 * @Description:
 */
public class Solution {
    public static void main(String[] args) {
        System.out.println(fun(7, 2));
    }
    public static int fun(int n, int m){
        Stack<Integer> stack = new Stack<>();
        while (n > 0){
            int temp = n % m;
            stack.push(temp);
            n = n / m;
        }
        int ans = 0;
        while (!stack.isEmpty()){
            ans += stack.pop();
        }
        return ans;
    }
}
