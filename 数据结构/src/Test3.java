import java.util.Arrays;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/15/18:29
 * @Description:
 */
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
//        quickSort(arr, 0, arr.length- 1);
        topk_small(arr, 2);
        System.out.println(Arrays.toString(arr));

    }
    // 常规快排
    public static void quickSort(int[] arr, int low, int high){
        if (low < high){
            int index = getIndex(arr, low, high);
            quickSort(arr, low, index - 1);
            quickSort(arr, index + 1, high);
        }
    }

    static void topk_split(int[] arr, int k, int low, int high){
        if (low < high){
            int index = getIndex(arr, low, high);
            if (index == k) return;
            else if (index < k) topk_split(arr, k, index + 1, high);
            else topk_split(arr, k, low, index - 1);
        }
    }

    static int[] topk_small(int[] arr, int k){
        int[] res = new int[k];
        topk_split(arr, k, 0 , arr.length - 1);
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        System.out.println(Arrays.toString(res));
        return res;
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
}
