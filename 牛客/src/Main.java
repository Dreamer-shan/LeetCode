import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Shan
 * @Description
 * @create 2021-08-01 14:59
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String next = sc.next();
        String[] a = next.split(":");
        int k = Integer.valueOf(a[1]);
        String[] split = a[0].split(",");
        int index = 0;
        int[] arr = new int[split.length];
        for (String s : split) {
            arr[index++] = Integer.valueOf(s);
        }
        String ans = window(arr, k);
        System.out.println(ans + "%");
    }

    private static String window(int[] arr, int k) {
        double sum = 0;
        double pre_sum = 0;
        int n = arr.length;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        pre_sum = sum;
        double temp = pre_sum / k;
        double max = 0;
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        for (int i = 0; i < n; i++) {
            pre_sum = sum;
            sum = sum - arr[i - k] + arr[i];
            double p = (sum - pre_sum) / k / temp * 100;
            temp = sum / k;
            System.out.println(sum+"\t"+pre_sum+"\t" + temp + "\t" + p);
            if (max < p){
                max = p;
            }
        }
        return decimalFormat.format(max);
    }
}
