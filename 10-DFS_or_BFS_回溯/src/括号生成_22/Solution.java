package src.括号生成_22;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/01/12:33
 * @Description:
 */
class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return res;
        }
        generate("",n,n);
        return res;
    }

    private void generate(String str,int left, int right) {
        if (left == 0 && right == 0){
            res.add(str);
            return;
        }
        //剩余左右括号数相等，下一个只能用左括号
        if (left == right){
            generate(str + "(", left - 1 ,right);
        }
        //剩余左括号小于右括号，下一个可以用左括号也可以用右括号
        if (left < right){
            if (left > 0){
                generate(str + "(", left - 1 ,right);
            }
            generate(str + ")", left ,right - 1);
        }
    }
}

//public class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> res = new ArrayList<>();
//        // 特判
//        if (n == 0) {
//            return res;
//        }
//        // 执行深度优先遍历，搜索可能的结果
//        dfs("", n, n, res);
//        return res;
//    }
//
//    /**
//     * @param curStr 当前递归得到的结果
//     * @param left   左括号还有几个可以使用
//     * @param right  右括号还有几个可以使用
//     * @param res    结果集
//     */
//    private void dfs(String curStr, int left, int right, List<String> res) {
//        // 因为每一次尝试，都使用新的字符串变量，所以无需回溯
//        // 在递归终止的时候，直接把它添加到结果集即可，注意与「力扣」第 46 题、第 39 题区分
//        if (left == 0 && right == 0){
//            res.add(curStr);
//            return;
//        }
//
//        if (left > right){
//            return;
//        }
//        if (left > 0){
//            dfs(curStr + "(", left - 1, right, res);
//        }
//        if (right > 0){
//            dfs(curStr + ")", left, right - 1, res);
//        }
//    }
//}
