//import java.util.Arrays;
//
///**
// * @author Shan
// * @Description
// * @create 2021-02-02 15:15
// */
//class Solution {
//    public int maxAreaOfIsland(int[][] grid) {
//        if (grid.length == 0 || grid[0].length == 0){
//            return 0;
//        }
//        int ans = 0;
//        int m = grid.length;
//        int n = grid[0].length;
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                ans = Math.max(dfs(grid, i, j), ans);
//            }
//        }
//        return ans;
//    }
//
//    public int dfs(int[][] m,int i,int j){
//        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] != 1){
//            return 0;
//        }
//        m[i][j] = 0;
//        int ans = 1;
//        int[] di = {0, 0, 1, -1};
//        int[] dj = {1, -1, 0, 0};
//        for (int index = 0; index < 4; index++) {
//            int next_i = i + di[index], next_j = j + dj[index];
//            ans += dfs(m, next_i, next_j);
//        }
//        return ans;
//    }
//}
//
//
//class Solution {
//    public void setZeroes(int[][] matrix) {
//        boolean row_flag = false;
//        boolean col_flag = false;
//        for (int i = 0; i < matrix.length; i++) {
//            if (matrix[i][0] == 0){
//                col_flag = true;
//                break;
//            }
//        }
//        for (int j = 0; j < matrix[0].length; j++) {
//            if (matrix[0][j] == 0){
//                row_flag = true;
//                break;
//            }
//        }
//        for (int i = 1; i < matrix.length; i++) {
//            for (int j = 1; j < matrix[0].length; j++) {
//                if (matrix[i][j] == 0){
//                    matrix[i][0] = matrix[0][j] = 0;
//                }
//            }
//        }
//        for (int i = 1; i < matrix.length; i++) {
//            for (int j = 1; j < matrix[0].length; j++) {
//                if (matrix[i][0] == 0 || matrix[0][j] == 0){
//                    matrix[i][j] = 0;
//                }
//            }
//        }
//        if (row_flag){
//            for (int i = 0; i < matrix.length; i++) {
//                matrix[i][0] = 0;
//            }
//        }
//        if (col_flag){
//            for (int j = 0; j < matrix[0].length; j++) {
//                matrix[0][j] = 0;
//            }
//        }
//    }
//}
//
//class Solution {
//    public int threeSumClosest(int[] nums, int target) {
//        Arrays.sort(nums);
//        int n = nums.length;
//        int ans = nums[0] + nums[1] + nums[2];
//        for (int i = 0; i < n; i++) {
//            if (i  > 0 && nums[i] == nums[i - 1]){
//                continue;
//            }
//            int l = i + 1, r = n - 1;
//            while (l < r){
//                int sum = nums[i] + nums[l] + nums[r];
//                if (Math.abs(target - sum) < Math.abs(target - ans)){
//                    ans = sum;
//                }
//                if (sum == target){
//                    return target;
//                }else if (sum < target){
//                    int l0 = l + 1;
//                    while (l0 < r && nums[l] == nums[l0]){
//                        l0++;
//                    }
//                    l = l0;
//                }else {
//                    int r0 = r - 1;
//                    while (l < r0 && nums[r] == nums[r0]){
//                        r0--;
//                    }
//                    r = r0;
//                }
//            }
//        }
//        return ans;
//    }
//}
//
//class Solution {
//    public int threeSumClosest(int[] nums, int target) {
//        if (nums.length < 3)    return 0;
//        int len = nums.length;
//        int res = nums[0] + nums[1] + nums[2];
//        Arrays.sort(nums);
//
//        for (int i = 0; i < len; i++) {
//            int l = i + 1, r = len - 1;
//            while (l < r){
//                int sum = nums[i] + nums[l] + nums[r];
//                if (Math.abs(sum - target) < Math.abs(res - target)){
//                    res = sum;
//                }
//                if (sum == target){
//                    return sum;
//                }else if (sum < target){
//                    l++;
//                }else {
//                    r--;
//                }
//            }
//        }
//        return res;
//    }
//}

import java.util.*;

//class Solution {
//    public static int[] findDiagonalOrder(int[][] matrix) {
//        Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
//        int row = matrix.length;
//        if (row == 0)   return new int[0];
//        int col = matrix[0].length;
//        for (int i = 0; i < row; i++) {
//            for (int j = 0; j < col; j++) {
//                if (!map.containsKey(i+j))
//                    map.put(i+j, new LinkedList<>());
//                if ((i+j) % 2 ==0)
//                    map.get(i+j).addFirst(matrix[i][j]);
//                if ((i+j) % 2== 1)
//                    map.get(i+j).addLast(matrix[i][j]);
//            }
//        }
//        int[] ans = new int[row*col];
//        int index = 0;
//        for (Integer key : map.keySet()) {
//            List<Integer> list = map.get(key);
//            for (int i = 0; i < list.size(); i++) {
//                ans[index++] = list.get(i);
//            }
//        }
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        int[][] p = {{1,2,3},{4,5,6},{7,8,9}};
//        int[] ans = findDiagonalOrder(p);
//        for (int an : ans) {
//            System.out.print(an + " ");
//        }
//    }
//}
//
//
//
//class Solution {
//    public int[] findDiagonalOrder(List<List<Integer>> nums) {
//        if (nums == null || nums.size() == 0 || nums.get(0).size() == 0)    return new int[0];
//        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
//        int m = nums.size(), n = nums.get(0).size();
//        int len = 0;
//        for(int i = 0; i < m; i++){
//            len += nums.get(i).size();
//            for(int j = 0; j < n; j++){
//                if (map.containsKey(i+j)){
//                    map.get(i+j).add(nums.get(i).get(j));
//                }else {
//                    List<Integer> list = new ArrayList<>();
//                    map.put(i+j, list);
//                }
//            }
//        }
//        int[] res = new int[len];
//        int index = 0;
//        for (Integer key : map.keySet()) {
//            List<Integer> list = map.get(key);
//            for (int i = list.size() - 1; i >= 0; i--) {
//                res[index++] = list.get(i);
//            }
//        }
//        return res;
//    }
//}

class Solution {
    public static int[] getLeastNumbers(int[] arr, int k) {
        quickselect(arr, 0, arr.length - 1, k);
        return Arrays.copyOfRange(arr, 0, k);
    }

    private static void quickselect(int[] nums, int start, int end, int k) {
        while (start < end) {
            // 这边做了了小优化，三数取中～前两步先确定最后一个一定是最大的，然后只要把中间那个数放第一个位置即可
            // 如果你嫌麻烦可以直接 int pivot = nums[start];
            int mid = start + (end - start) / 2;
            if (nums[start] > nums[end]) swap(nums, start, end);
            if (nums[mid] > nums[end]) swap(nums, mid, end);
            if (nums[mid] > nums[start]) swap(nums, mid, start);
            int pivot = nums[start];

            int i = start, j = end;
            while (i <= j) {
                //升序～
                while (i <= j && nums[i] < pivot) i++;
                while (i <= j && nums[j] > pivot) j--;
                if (i <= j) {
                    swap(nums,i,j);
                    i++;
                    j--;
                }
            }
            if (i >= k) {
                end = i - 1;
            } else {
                start = i;
            }
        }
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,3,4,2,5,6,10,8,7};
        int[] numbers = getLeastNumbers(arr, 2);
        System.out.println(Arrays.toString(numbers));
    }
}
