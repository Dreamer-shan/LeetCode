package 完全平方数_279;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/09/20:10
 * @Description:
 */
class Solution {
    public static void main(String[] args) {
        numSquares1(16);
    }
    public static int numSquares(int n) {
        Queue<Integer> queue=new LinkedList<>();
        HashSet<Integer> visited=new HashSet<>();
        queue.offer(n);
        visited.add(n);
        int level=0;

        while(!queue.isEmpty()){
            level++;
            int len=queue.size();

            for(int i=0;i<len;i++){
                int cur=queue.poll();
                for(int j=1;j*j<=cur;j++){
                    int tmp=cur-j*j;
                    if(tmp==0)
                        return level;
                    if(!visited.contains(tmp))
                        queue.offer(tmp);
                    visited.add(tmp);
                }
            }
        }
        return level;
    }


        public static int numSquares1(int n) {
            int[] f = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                int minn = Integer.MAX_VALUE;
                for (int j = 1; j * j <= i; j++) {
                    minn = Math.min(minn, f[i - j * j]);
                }
                f[i] = minn + 1;
            }
            return f[n];
        }



}
