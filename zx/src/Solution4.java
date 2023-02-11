
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Shan
 * @Description
 * @create 2021-04-24 13:59
 */
public class Solution4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer>[] stack = new Stack[5];
        for (int i = 0; i < 5; i++) {
            stack[i] = new Stack<>();
        }
        int[] arr = new int[5];
        int size = 0;
        for (int i = 0; i < n; i++) {
            int mission = sc.nextInt();
            stack[mission - 1].push(i + 1);
            if (arr[mission - 1] == 0) {
                arr[mission - 1] = 1;
                size++;
                if (size == 5) {
                    int[] nums = new int[5];
                    for (int j = 0; j < 5; j++) {
                        arr[j] = arr[j] - 1;
                        if (arr[j] == 0) {
                            size--;
                        }
                        nums[j] = stack[j].pop();
                    }
                    for (int j = 0; j < 5; j++) {
                        if (j == 4) System.out.println(nums[j]);
                        else System.out.print(nums[j] + " ");
                    }
                } else {
                    System.out.println(-1);
                }
            } else {
                arr[mission - 1] += 1;
                System.out.println(-1);
            }
        }
    }
}