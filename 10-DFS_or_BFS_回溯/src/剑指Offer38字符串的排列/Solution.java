package src.剑指Offer38字符串的排列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/24/14:54
 * @Description:
 */
public class Solution {
    public String[] permutation(String s) {
        int len = s.length();
        if (len == 0)   return new String[0];
        // 转换成字符数组是常见的做法
        char[] charArray = s.toCharArray();
        // 排序是为了去重方便
        Arrays.sort(charArray);
        StringBuilder path = new StringBuilder();
        boolean[] visited = new boolean[len];

        List<String> res = new ArrayList<>();
        dfs(charArray, len, 0, visited, path, res);
        // 记得转成字符串数组
        // 用来创建一个数组类型对象，但是里面没有任何东西
        return res.toArray(new String[0]);
    }

    /**
     *
     * @param charArray 字符数组
     * @param len   字符数组长度
     * @param depth 当前递归深度
     * @param visited   是否访问过
     * @param path  根节点到叶子结点的路径
     * @param res   结果集
     */
    private void dfs(char[] charArray, int len, int depth, boolean[] visited, StringBuilder path, List<String> res) {
        if (depth == len){
            res.add(path.toString());
            return;
        }
        for (int i = 0; i < len; i++) {
            if (!visited[i]){
                if (i > 0 && charArray[i] == charArray[i - 1] && !visited[i - 1]){
                    continue;
                }
                visited[i] = true;
                path.append(charArray[i]);
                dfs(charArray, len, depth + 1, visited, path, res);
                path.deleteCharAt(path.length() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "";

        String[] permutation = solution.permutation(s);
        for (String s1 : permutation) {
            System.out.println(s1);
        }
    }
}
