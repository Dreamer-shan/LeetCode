package 美团;

import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/28/21:27
 * @Description:
 */
class Solution {
    public static String removeDuplicates(String str){
        StringBuilder sb = new StringBuilder();
        if(str == null || str.length() == 0)    return sb.toString();
        Stack<Character> stack = new Stack<>();
        stack.push(str.charAt(0));
        for(int i = 1; i < str.length(); i++){
                if(!stack.isEmpty() && str.charAt(i) == stack.peek()){
                    stack.pop();
                }else{
                    stack.push(str.charAt(i));
                }
        }
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String s = "abba";
        String s1 = "abbba";
        System.out.println(removeDuplicates(s));
        System.out.println(removeDuplicates(s1));
    }
}

