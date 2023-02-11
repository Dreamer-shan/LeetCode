package 前K个高频元素_347;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/24/17:01
 * @Description:
 */
//避免使用大根堆，因为你得把所有元素压入堆，复杂度是 nlogn，而且还浪费内存。如果是海量元素，那就挂了
//对于 topk 问题：最大堆求topk小，最小堆求 topk 大
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for (Integer key : map.keySet()) {
            if (queue.size() < k){
                queue.offer(key);
            }else if (map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.offer(key);
            }
        }
        int[] res = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()){
            res[index++] = queue.poll();
        }
        return res;
    }

    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));
        for (Integer key : map.keySet()) {
            if (queue.size() < k){
                queue.offer(key);
            }else if (map.get(key) > map.get(queue.peek())){
                queue.poll();
                queue.offer(key);
            }
        }
        int[] res = new int[queue.size()];
        int index = 0;
        while (!queue.isEmpty()){
            res[index++] = queue.poll();
        }
        return res;
    }
}