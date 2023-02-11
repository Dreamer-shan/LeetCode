package 富途;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/12/17:50
 * @Description:
 */
public class Solution2 {
    public int maxDistance (int[] arr) {
        // write code here
        int n = arr.length;
        if (n < 2)  return 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        int d = Math.max(1, (max - min) / ( n - 1));
        int bucketSize = (max - min) / d + 1;
        int[][] bucket = new int[bucketSize][2];
        for (int i = 0; i < bucketSize; i++) {
            Arrays.fill(bucket[i], -1);
        }
        for (int i = 0; i < n; i++) {
            int index = (arr[i] - min) / d;
            if (bucket[index][0] == -1){
                bucket[index][0] = bucket[index][1] = arr[i];
            }else {
                bucket[index][0] = Math.min(bucket[index][0], arr[i]);
                bucket[index][1] = Math.min(bucket[index][1], arr[i]);
            }
        }
        int res = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (bucket[i][0] == -1){
                continue;
            }
            if (prev != -1){
                res = Math.max(res, bucket[i][0] - bucket[prev][1]);
            }
            prev = i;
        }
        return prev;
    }
}
