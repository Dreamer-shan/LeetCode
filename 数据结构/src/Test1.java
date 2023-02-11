import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/08/08/12:31
 * @Description:
 */
public class Test1 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < arr.length; i++) {
//            arr[i] = sc.nextInt();
//        }
//        int res = maxSum(arr);
//        System.out.println(res);

    }

//    private static int maxSum(int[] arr) {
//        int n = arr.length;
//        if (arr.length == 1)    return arr[0];
//        int[] dp = new int[n];
//        dp[0] = arr[0];
//        int max = dp[0];
//        for (int i = 1; i < n; i++) {
//            if (dp[i - 1] < 0){
//                dp[i] = arr[i];
//            }else {
//                dp[i] += dp[i - 1] + arr[i];
//            }
//            max = Math.max(max, dp[i]);
//        }
//        return max;
//    }
    public static void quickSort(int[] arr, int low, int high){
        int index = getIndex(arr, low, high);
        if (low < high){
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }
    public static int getIndex(int[] arr, int low, int high){
        int temp = arr[low];
        while (low < high){
            while (low < high && arr[high] >= temp){
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= temp){
                low++;
            }
            arr[high] = arr[low];
        }
        arr[low] = temp;
        return low;
    }

    public static void buildHeap(int[] arr, int n){
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    private static void heapify(int[] arr, int i, int n) {
        int l = 2 * i + 1, r = 2 * i + 2, largeIndex = i;
        if (l < r && arr[largeIndex] < arr[l])  largeIndex = l;
        if (l < r && arr[largeIndex] < arr[r])  largeIndex = r;
        if (largeIndex != i){
            swap(arr, i, largeIndex);
            heapify(arr, largeIndex, n);
        }
    }

    private static void swap(int[] arr, int i, int largeIndex) {

    }


}

class Singleton{
    private static Singleton instance = null;
    private Singleton(){}

    public synchronized static Singleton getInstance() {
        if (instance == null){
            return  new Singleton();
        }
        return instance;
    }
}