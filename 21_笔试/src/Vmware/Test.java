package Vmware;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/19/17:13
 * @Description:
 */
public class Test {
    public static void main(String[] args) {

    }

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<>();
//        Arrays.sort(intervals, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] - o2[0];
//            }
//        });
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int l = intervals[0][0];
        int r = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            if(intervals[i][0] > r){
                res.add(new int[]{l, r});
                l = intervals[i][0];
                r = intervals[i][1];
            }else{
                r = Math.max(r, intervals[i][1]);
            }
        }
        res.add(new int[]{l, r});
        return res.toArray(new int[][]{});
    }
}
