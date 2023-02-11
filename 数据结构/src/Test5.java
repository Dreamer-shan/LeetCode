import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/23/20:57
 * @Description:
 */
public class Test5 {
    public static void main(String[] args) {
//        int[] arr = {1,2,3,7};
        int[] arr = {1,1,3,3,5,5,7,7};
        Set<Integer> set = new HashSet<>();
        Arrays.sort(arr);
        int slow = 0, fast = 1;
        int count = 0;
        while(fast < arr.length){
            if (arr[fast] - arr[slow] < 5){
                count++;
                slow = slow + 2;
                fast = fast + 2;
            }else {
                slow = fast;
                fast = fast + 1;
            }
        }
        System.out.println(count);
    }
}
