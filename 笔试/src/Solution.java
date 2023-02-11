import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author Shan
 * @Description
 * @create 2021-06-29 22:45
 */

// 求无序数组的中位数
public class Solution {
    public static void main(String[] args) {
        int[] arr = {23,5,6,8,2,3};
        double ans = help(arr);
        System.out.println(ans);
        String str = "asdasd";
    }
    public static  double help(int[] arr){
        if (arr.length == 0)    return 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0){
                maxHeap.offer(arr[i]);
                minHeap.offer(maxHeap.poll());
            }else{
                minHeap.offer(arr[i]);
                maxHeap.offer(minHeap.poll());
            }
        }
        return arr.length % 2 == 0 ? (minHeap.peek() + maxHeap.peek()) / 2.0 : minHeap.peek();
    }
}