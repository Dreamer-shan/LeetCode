package 京东;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int max_idx = 0, min_idx = 0;

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] > max){
                max = arr[i];
                max_idx = i;
            }
            if (arr[i] < min){
                min = arr[i];
                min_idx = i;
            }
        }

        int step = 0;
        if (max_idx < n / 2 && max_idx < n / 2){
            for (int i = 0; i < arr.length; i++) {
                step++;
                int index = Math.max(min_idx, max_idx);
                System.out.println(index+1);
            }
        }else if (max_idx > n / 2 && max_idx > n / 2){
            for (int i = arr.length - 1; i >= 0; i--) {
                int index = Math.min(min_idx, max_idx);
                step++;
                if (arr[i] == index){
                    System.out.println(step);
                }
            }
        }else {
            step++;
        }


    }
}
