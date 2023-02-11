package 小测试;

import java.awt.print.Pageable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/01/20:54
 * @Description:
 */
public class Test {

    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] window = maxSlidingWindow(arr,3 );
        System.out.println(Arrays.toString(window));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length == 0 || nums == null){
            return new int[0];
        }
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        for(int i = 0; i < n - k + 1; i++){
            ans[i] = nums[i];
            for(int j = i; j < i + k; j++){
                ans[i] = Math.max(nums[i], nums[j]);
            }
        }
        return ans;
    }
}