package 验证栈序列;

import java.util.Stack;

/**
 * @author Shan
 * @Description 946
 * @create 2020-11-23 22:53
 */
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        for (int x : pushed) {
            st.push(x);
            if (!st.empty() && st.peek() == popped[index]){
                st.pop();
                index++;
            }
        }
        return st.empty();
    }
}