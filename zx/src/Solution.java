import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author Shan
 * @Description
 * @create 2021-04-24 13:59
 */
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int u = sc.nextInt();
        int[] a = new int[n];
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            queue.offer(a[i]);
        }
        while (h < u){
            h += queue.poll();
            count++;
        }
        System.out.println(count);
    }
}
