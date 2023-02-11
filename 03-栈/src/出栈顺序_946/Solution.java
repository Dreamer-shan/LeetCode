package 出栈顺序_946;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/11/23/9:33
 * @Description:
 */
class Solution {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        for (int x : pushed) {
            st.push(x);
            while (!st.empty() && st.peek() == popped[index]){
                st.pop();
                index++;
            }
        }
        return st.empty();
    }

    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int index = 0;
        for (int x : pushed) {
            st.push(x);
            while (!st.empty() && st.peek() == popped[index]){
                st.pop();
                index++;
            }
        }
        return st.empty();
    }

    public static void main(String[] args) {
        int[] pushed = {1,2,3,4,5};
        int[] poped = {4,5,3,2,1};
        validateStackSequences(pushed, poped);
    }
}