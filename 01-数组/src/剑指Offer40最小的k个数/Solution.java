package 剑指Offer40最小的k个数;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/24/15:12
 * @Description:
 */
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) return new int[0];
        Arrays.sort(arr);
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }
        return ans;
    }

    public int[] getLeastNumbers2(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0 || arr.length == 0) return new int[0];
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            queue.offer(arr[i]);
        }
        for (int i = k; i < arr.length; i++) {
            if (queue.peek() > arr[i]) {
                queue.poll();
                queue.offer(arr[i]);
            }
        }
        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }
        return ans;
    }

    public int[] getLeastNumbers3(int[] arr, int k) {
        int[] ans = new int[k];
        if (k == 0 || arr.length == 0) return new int[0];
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        PriorityQueue<Integer> queue = new PriorityQueue<>((num1, num2) -> num2 - num1);
        for (int num : arr) {
            // 堆中元素个数小于k，继续添加元素
            if (queue.size() < k) {
                queue.offer(num);
                // 堆中元素大于等于k，且堆顶元素大于当前元素，弹出堆顶。
            } else if (queue.peek() > num) {
                queue.poll();
                queue.offer(num);
            }
        }
        int index = 0;
        for (Integer num : queue) {
            ans[index++] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 2, 1};
        int k = 2;
        for (int number : solution.getLeastNumbers(arr, k)) {
            System.out.println(number);
        }
    }


}



