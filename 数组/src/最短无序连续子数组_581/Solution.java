package 最短无序连续子数组_581;

import java.util.Arrays;

/**
 * @author Shan
 * @Description
 * @create 2020-11-25 12:03
 */
class Solution {
    public int countTriplets(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int k = i + 1; k < arr.length; k++) {
                temp ^= arr[k];
                if (temp == 0){
                    count += k - i;
                }
            }
        }
        return count;
    }
}