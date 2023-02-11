package 同城58;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/11/20:28
 * @Description:
 */
import java.util.*;


public class Solution1 {
    public int[] subArraySum (int[] Array, int arrayLen, int subArrayLen) {
        // write code here

        int sum = 0;
        for (int i = 0; i < subArrayLen; i++) {
            sum += Array[i];
        }
        int temp = sum;
        int index = 0;
        for (int i = subArrayLen; i < arrayLen; i++) {
            sum += Array[i] - Array[i - subArrayLen];
            if (sum > temp){
                temp = sum;
                index = i - subArrayLen + 1;
            }
        }
        return new int[]{index, temp};
//        return fun(Array, subArrayLen);

    }

//    int[] fun(int[] nums, int k){
//        int sum = 0;
//        for (int i = 0; i < k; i++) {
//            sum += nums[i];
//        }
//        int res = sum;
//        int index = 0;
//        for (int i = 0; i < nums.length; i++) {
//            sum += nums[i] - k;
//            if (res < sum){
//                index++;
//            }
//            res = Math.max(res, sum);
//        }
//        return new int[]{index, res};
//    }
}