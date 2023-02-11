package src.朋友圈_547;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2020/12/19/20:50
 * @Description:
 */
class Solution {
    public int findCircleNum1(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0){
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }
    void dfs(int[][] M, int[] visited, int i){
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0){
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }

    public int findCircleNum2(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        // 注意队列的实现方式
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0){
                queue.add(i);
                while (!queue.isEmpty()){
                    // 取队首元素s
                    int s = queue.remove();
                    visited[s] = 1;
                    // 遍历s的朋友
                    for (int j = 0; j < M.length; j++) {
                        if (M[s][j] == 1 && visited[j] == 0){
                            // j是s的朋友且j没被访问过，将j加入队列
                            queue.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}




