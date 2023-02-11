//////////import java.util.ArrayList;
//////////import java.util.Arrays;
//////////import java.util.Collections;
//////////import java.util.Comparator;
//////////import java.util.List;
//////////import java.util.Stack;
//////////
//////////
//////////public class Solution {
//////////
//////////    public int[][] merge(int[][] intervals) {
//////////        int len = intervals.length;
//////////        if (len < 2) {
//////////            return intervals;
//////////        }
//////////
//////////        // 按照起点排序
//////////        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
//////////
//////////        // 也可以使用 Stack，因为我们只关心结果集的最后一个区间
//////////        List<int[]> res = new ArrayList<>();
//////////        res.add(intervals[0]);
//////////
//////////        for (int i = 1; i < len; i++) {
//////////            int[] curInterval = intervals[i];
//////////
//////////            // 每次新遍历到的列表与当前结果集中的最后一个区间的末尾端点进行比较
//////////            int[] peek = res.get(res.size() - 1);
//////////
//////////            if (curInterval[0] > peek[1]) {
//////////                res.add(curInterval);
//////////            } else {
//////////                // 注意，这里应该取最大
//////////                peek[1] = Math.max(curInterval[1], peek[1]);
//////////            }
//////////        }
//////////        return res.toArray(new int[res.size()][]);
//////////    }
//////////
//////////    public static void main(String[] args) {
//////////        Solution solution = new Solution();
//////////        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
//////////        int[][] res = solution.merge(intervals);
//////////        for (int i = 0; i < res.length; i++) {
//////////            System.out.println(Arrays.toString(res[i]));
//////////        }
//////////    }
//////////}
//////////
////////
////////import com.sun.source.tree.Tree;
////////
////////import javax.swing.tree.TreeNode;
////////import java.util.*;
////////
////////
////////
////////
////////class Solution {
////////    public double myPow(double x, int n) {
////////        long N = n;
////////        if (N < 0) {
////////            return pow_1(1/x, -N);
////////        }
////////        return pow_1(x, N);
////////    }
////////    double pow_1(double x, long n){
////////        if (n == 0) return 1;
////////        if (x == 1) return 1;
////////        if ((n & 1) == 0){
////////            double ans = pow_1(x, n / 2);
////////            return ans * ans;
////////        }else {
////////            double ans = pow_1(x, (n - 1) / 2);
////////            return ans * ans * x;
////////        }
////////    }
////////}
////////
////////
////////
////////class Solution {
////////    public int[] exchange(int[] nums) {
////////        int l = 0, r = nums.length - 1;
////////        while (l < r){
////////            if ((nums[l] & 1) == 1){
////////                l++;
////////                continue;
////////            }
////////            if ((nums[r] & 1) == 0){
////////                r--;
////////                continue;
////////            }
////////            int temp = nums[l];
////////            nums[l] = nums[r];
////////            nums[r] = temp;
////////            l++;
////////            r--;
////////        }
////////        return nums;
////////
////////    }
////////}
////////
////////class Solution {
////////    public int[] levelOrder(TreeNode root) {
////////        List<Integer> list = new ArrayList<>();
////////        LinkedList<TreeNode> queue = new LinkedList<>();
////////
////////        if (root == null)   return new int[]{};
////////        queue.add(root);
////////        while (!queue.isEmpty()){
////////            TreeNode node = queue.poll();
////////            list.add(node.val);
////////            if (node.left != null)  queue.add(node.left);
////////            if (node.right != null)  queue.add(node.right);
////////        }
////////        int[] ans = new int[list.size()];
////////        for (int i = 0; i < list.size(); i++) {
////////            ans[i] = list.get(i);
////////        }
////////        return ans;
////////    }
////////}
////////
////////class Solution {
////////    public List<List<Integer>> levelOrder(TreeNode root) {
////////        List<List<Integer>> ans = new ArrayList<>();
////////        if (root == null)   return ans;
////////        Queue<TreeNode> queue = new LinkedList<>();
////////        queue.add(root);
////////        while(!queue.isEmpty()){
////////            List<Integer> tmp = new ArrayList<>();
////////            TreeNode node = queue.poll();
////////            tmp.add(root.val);
////////            if (node.left != null)  queue.add(node.left);
////////            if (node.right != null)  queue.add(node.right);
////////            ans.add(tmp);
////////        }
////////        return ans;
////////    }
////////}
////////
////////class Solution {
////////    public List<List<Integer>> levelOrder(TreeNode root) {
////////        List<List<Integer>> ans = new LinkedList<>();
////////        if (root == null)   return ans;
////////        Queue<TreeNode> queue = new LinkedList<>();
////////        int level = 1;
////////        while (!queue.isEmpty()){
////////            LinkedList<Integer> temp = new LinkedList<>();
////////            for (int i = queue.size(); i > 0; i--) {
////////                TreeNode node = queue.poll();
////////                if (level % 2 == 1){
////////                    temp.addFirst(node.val);
////////                }else {
////////                    temp.addLast(node.val);
////////                }
////////                if (node.left != null)  queue.add(node.left);
////////                if (node.right != null)  queue.add(node.right);
////////            }
////////            ans.add(temp);
////////        }
////////        return ans;
////////    }
////////}
//////
//////class Solution {
//////    public boolean isMatch(String A, String B) {
//////        int n = A.length();
//////        int m = B.length();
//////        boolean[][] f = new boolean[n + 1][m + 1];
//////
//////        for (int i = 0; i <= n; i++) {
//////            for (int j = 0; j <= m; j++) {
//////                //分成空正则和非空正则两种
//////                // 空正则一定不匹配
//////                if (j == 0) {
//////                    f[i][j] = i == 0;
//////                } else {
//////                    //非空正则分为两种情况 * 和 非*
//////                    if (B.charAt(j - 1) != '*') {
//////                        if (i > 0 && (A.charAt(i - 1) == B.charAt(j - 1) || B.charAt(j - 1) == '.')) {
//////                            f[i][j] = f[i - 1][j - 1];
//////                        }
//////                    } else {
//////                        //碰到 * 了，分为看和不看两种情况
//////                        //不看 abb 和abbc*
//////                        if (j >= 2) {
//////                            f[i][j] |= f[i][j - 2];
//////                        }
//////                        //看 abb 和abbc*
//////                        if (i >= 1 && j >= 2 && (A.charAt(i - 1) == B.charAt(j - 2) || B.charAt(j - 2) == '.')) {
//////                            f[i][j] |= f[i - 1][j];
//////                        }
//////                    }
//////                }
//////            }
//////        }
//////        return f[n][m];
//////    }
//////}
//////
////
//////import java.util.HashMap;
//////import java.util.LinkedHashMap;
//////import java.util.Map;
//////
//////class Solution {
//////    public static char firstUniqChar(String s) {
//////        if (s == null)  return ' ';
//////        int[] count = new int[256];
//////        char[] chars = s.toCharArray();
//////        for (char c : chars) {
//////            count[c]++;
//////        }
//////        for (char c : chars) {
//////            if (count[c] == 1)  return c;
//////        }
//////        return ' ';
//////    }
//////
//////    public static void main(String[] args) {
//////        String s = "leetcode";
//////        char c = firstUniqChar(s);
//////        System.out.println(c);
//////    }
//////}
////
//////class Solution {
//////    int count = 0;
//////    public int search(int[] nums, int target) {
//////        helper(nums, 0, nums.length - 1, target);
//////        return count;
//////    }
//////
//////    void helper(int[] nums, int left, int right, int target) {
//////        if (left <= right){
//////            int mid = left + (right - left) / 2;
//////            if (nums[mid] == target) {
//////                count++;
//////                helper(nums, left, mid - 1, target);
//////                helper(nums, mid + 1, right, target);
//////            } else if (nums[mid] > target) {
//////                helper(nums, left, mid - 1, target);
//////            } else {
//////                helper(nums, mid + 1, right, target);
//////            }
//////        }
//////    }
//////}
////
//////import java.util.*;
//////
//////class Solution {
//////    public int translateNum(int num) {
//////        String s = String.valueOf(num);
//////        int n = s.length();
//////        int[] dp = new int[n + 1];
//////        dp[0] = 1;
//////        dp[1] = 1;
//////        for (int i = 2; i <= n; i++) {
//////            String temp = s.substring(i - 2, i);
//////            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0){
//////                dp[i] = dp[i - 1] + dp[i - 2];
//////            }else {
//////                dp[i] = dp[i - 1];
//////            }
//////        }
//////        return dp[n];
//////    }
//////}
//////
//////class Solution {
//////    public int[] twoSum(int[] nums, int target) {
//////        int l = 0, r = nums.length - 1;
//////        while (l < r){
//////            if (nums[l] + nums[r] == target){
//////                return new int[]{nums[l], nums[r]};
//////            }else if (nums[l] + nums[r] < target){
//////                l++;
//////            }else {
//////                r--;
//////            }
//////        }
//////        return new int[0];
//////    }
//////
//////    public int[] twoSum2(int[] nums, int target) {
//////        Set<Integer> set = new HashSet<>();
//////        for (int num : nums) {
//////            set.add(num);
//////        }
//////        for (int num : nums) {
//////            if (set.contains(target-num)){
//////                return new int[]{num,target-num};
//////            }
//////        }
//////        return new int[0];
//////    }
//////}
//////
//////class Solution {
//////    public int[][] findContinuousSequence(int target) {
//////        List<int[]> res = new ArrayList<>();
//////        for (int l = 1, r = 2; l < r;) {
//////            int sum = (l + r) * (r - l + 1) / 2;
//////            if (sum == target){
//////                int[] tmp = new int[r - l + 1];
//////                for (int i = l; i <= r; i++) {
//////                    tmp[i - l] = i;
//////                }
//////                res.add(tmp);
//////                l++;
//////            }else if (sum < target){
//////                r++;
//////            }else {
//////                l++;
//////            }
//////        }
//////        return res.toArray(new int[0][]);
//////    }
//////}
//////
//////class Solution {
//////    public static String reverseWords(String s) {
//////        s = s.trim();
//////        int j = s.length() - 1, i = j;
//////        StringBuilder sb = new StringBuilder();
//////        while (i >= 0){
//////            while(i >= 0 && s.charAt(i) != ' ') i--;    // 搜索单词的前一个空格
//////            sb.append(s.substring(i + 1, j + 1));
//////            while (i >= 0 && s.charAt(i) == ' ')    i--;    // 跳过单词间的空格 "a good   example"
//////            j = i;  //j指向下个单词的尾字符
//////        }
//////        return sb.toString().trim();
//////    }
//////
//////    public static void main(String[] args) {
//////        String s = "a good   example";
//////        System.out.println(reverseWords(s));
//////    }
//////}
////
//////public class Solution {
//////
//////    /**
//////     * @param args
//////     */
//////    public static void main(String[] args) {
//////        // TODO Auto-generated method stub
//////        int[] nums = new int[]{1,2,4,3,3,4,1,2,7};
//////        System.out.println(singleNumber(nums));
//////    }
//////    public static int singleNumber(int[] nums){
//////        //不借助额外空间，得到只出现一次的数据
//////        int num = 0;
//////        for(int i = 0;i<nums.length;i++){
//////            num ^= nums[i];
//////        }
//////        return num;
//////    }
//////}
////
//////import java.util.Arrays;
//////
//////class Solution {
//////    public static int[] singleNumbers(int[] nums) {
//////        int a = 0, b = 0, m = 1, n =0;
//////        for(int num : nums){
//////            n ^= num;
//////        }
//////        while((n & m) == 0){
//////            m <<= 1;
//////        }
//////        for(int num : nums){
//////            if((num & m) != 0){
//////                a ^= num;
//////            }
//////            else{
//////                b ^= num;
//////            }
//////        }
//////        return new int[]{a, b};
//////    }
//////
//////    public static void main(String[] args) {
//////        int[] a = {4,4,5,5,7,11};
//////        int[] ints = singleNumbers(a);
//////        System.out.println(Arrays.toString(ints));
//////    }
//////}
////
//////class Solution {
//////    public static int[] singleNumbers(int[] nums) {
//////        int sum = 0;
//////        // 将所有数字异或
//////        for (int num : nums) {
//////            sum ^= num;
//////        }
//////        // 找到二进制中第一位是1的数
//////        int mask = 1;
//////        while ((mask & sum) == 0){
//////            mask <<= 1;
//////        }
//////        int a =0, b = 0;
//////        for (int num : nums) {
//////            // 分组
//////            if ((num & mask) == 0){
//////                a ^= num;
//////            }else {
//////                b ^= num;
//////            }
//////        }
//////        return new int[]{a, b};
//////    }
//////
//////    public static void main(String[] args) {
//////        int[] a = {4,1,4,6};
//////        int[] ints = singleNumbers(a);
//////    }
//////}
////
//////import java.util.Arrays;
//////
//////class Solution {
//////    public static int singleNumber(int[] nums) {
//////        Arrays.sort(nums);
//////        for (int i = 0; i < nums.length; i+=3) {
//////            if (nums[i] != nums[i + 2]){
//////                return nums[i];
//////            }
//////        }
//////        return nums[nums.length - 1];
//////    }
//////
//////    public static int singleNumber2(int[] nums) {
//////        int[] bitArr = new int[32];
//////        for (int i = 0; i < nums.length; i++) {
//////            for (int j = 0; j < 32; j++) {
//////                bitArr[j] += nums[i] & 1;   // 更新bit数组的第 j 位
//////                nums[i] >>>= 1; // 第 j 位 --> 第 j + 1 位
//////            }
//////        }
//////        int res = 0, m = 3;
//////        //
//////        for (int i = 0; i < 32; i++) {
//////            res <<= 1;  // 左移一位
//////            res |= bitArr[31 - i] % m;  // 恢复第 i 位的值到 res   res += bitArr[31 - i] % m;也可以
//////        }
//////        return res;
//////    }
//////
//////    public static void main(String[] args) {
//////        int[] a = {3, 5, 3, 3};
//////        System.out.println(singleNumber(a));
//////    }
//////}
////
//////class Solution {
//////    public static String reverseLeftWords(String s, int n) {
//////        StringBuilder sb = new StringBuilder();
//////        char[] chars = s.toCharArray();
//////        if (n == chars.length) {
//////            sb.append(s);
//////            return sb.reverse().toString();
//////        }
//////        for (int i = n; i < chars.length; i++) {
//////            sb.append(chars[i]);
//////        }
//////        for (int i = 0; i < n; i++) {
//////            sb.append(chars[i]);
//////        }
//////        return sb.toString();
//////    }
//////
//////    public static String reverseLeftWords2(String s, int n) {
//////        System.out.println(s.substring(n, s.length()));
//////        System.out.println(s.substring(0, n));
//////        return s.substring(n, s.length()) + s.substring(0, n);
//////    }
//////
//////    public static String reverseLeftWords3(String s, int n) {
//////        StringBuilder sb = new StringBuilder();
//////        for (int i = n; i < s.length(); i++) {
//////            sb.append(s.charAt(i));
//////        }
//////        for (int i = 0; i < n; i++) {
//////            sb.append(s.charAt(i));
//////        }
//////        return sb.toString();
//////    }
//////
//////    public static String reverseLeftWords4(String s, int n) {
//////        StringBuilder sb = new StringBuilder();
//////        // 循环 s.length() 次
//////        // 当 i 从 n 增长到 s.length()的时候 i % s.length()为 [n, s.length() - 1]
//////        // 当 i 从 s.length() 增长到 n + s.length()的时候, i % s.length()为 [0, n - 1]
//////        for (int i = n; i < s.length() + n; i++) {
//////            System.out.println(i % s.length());
//////            sb.append(s.charAt(i % s.length()));
//////        }
//////        return sb.toString();
//////    }
//////
//////    public static void main(String[] args) {
//////        System.out.println(reverseLeftWords4("abcd", 1));
//////    }
//////
//////}
////
////
////import java.util.Arrays;
////import java.util.Map;
////
////class Solution {
////    public static int[] maxSlidingWindow(int[] nums, int k) {
////        if (nums.length == 0) return new int[0];
////        if (k == 1) return nums;
////        int[] res = new int[nums.length - k + 1];
////        for (int i = 0; i <= nums.length - k; i++) {
////            int maxNum = Integer.MIN_VALUE;
////            for (int j = i; j < i + k; j++) {
////                maxNum = Math.max(maxNum, nums[j]);
////            }
////            res[i] = maxNum;
////        }
////        return res;
////    }
////
////    public static int[] maxSlidingWindow2(int[] nums, int k) {
////        if (nums.length == 0 || k > nums.length) return new int[0];
////        if (k == 1) return nums;
////        int len = nums.length - k + 1;
////        int[] res = new int[len];
////        for (int i = 0; i < len; i++) {
////            int max = Integer.MIN_VALUE;
////            for (int j = 0; j < k; j++) {
////                max = Math.max(max, nums[i + j]);
////            }
////            res[i] = max;
////        }
////        return res;
////    }
////
////    public static int[] maxSlidingWindow3(int[] nums, int k) {
////        if (nums.length == 0 || k > nums.length) return new int[0];
////        int len = nums.length - k + 1;
////        int[] res = new int[len];
////        int max = nums[0];
////        for (int i = 0; i < k; i++) {
////            max = Math.max(max, nums[i]);
////        }
////        res[0] = max;
////        for (int i = 1; i <= nums.length -k; i++) {
////            if (nums[i - 1] == max) {
////                max = nums[i];
////                for (int j = i + 1; j < i + k; j++) {
////                    max = Math.max(max, nums[i + j]);
////                }
////            } else {
////                max = Math.max(max, nums[i + k - 1]);
////            }
////            res[i] = max;
////        }
////        return res;
////    }
////
////    public static void main(String[] args) {
////        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
////        int[] ints = maxSlidingWindow(a, 3);
////        System.out.println(Arrays.toString(ints));
////    }
////}
//
//import java.util.*;
//
////class Solution {
////    public int maxValue(int[][] grid) {
////        if(grid.length == 0 || grid[0].length == 0) return 0;
////        int m = grid.length, n = grid[0].length;
////        int[][] dp = new int[m+1][n+1];
////        for(int i = m - 1; i >= 0; i--){
////            for(int j = n - 1; j >= 0; j--){
////                dp[i][j] = grid[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j]);
////            }
////        }
////        return dp[0][0];
////    }
////}
//
////class Solution {
////    public boolean searchMatrix(int[][] matrix, int target) {
////        if(matrix.length == 0 || matrix[0].length == 0) return false;
////        int m = matrix.length, n = matrix[0].length;
////        int[] arr = new int[m*n];
////        int l = 0, r= m * n - 1;
////        while(l <= r){
////            int mid_idx = l + ( r- l) / 2;
////            int mid_value = matrix[mid_idx / n][mid_idx % n];
////            if(mid_value == target){
////                return true;
////            }else if(mid_value < target){
////                l = mid_idx + 1;
////            }else{
////                r = mid_idx - 1;
////            }
////        }
////        return false;
////    }
////}
//
//
////class Solution {
////    public int[] findDiagonalOrder(List<List<Integer>> nums) {
////        if (nums == null || nums.size() == 0 || nums.get(0).size() == 0)    return new int[0];
////        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
////        int len = 0;
////        for(int i = 0; i < nums.size(); i++){
////            len += nums.get(i).size();
////            for(int j = 0; j < nums.get(i).size(); j++){
////                if (map.containsKey(i+j)){
////                    map.get(i+j).add(nums.get(i).get(j));
////                }else {
////                    List<Integer> list = new ArrayList<>();
////                    list.add(nums.get(i).get(j));
////                    map.put(i+j, list);
////                }
////            }
////        }
////        int[] res = new int[len];
////        int index = 0;
////        for (Integer key : map.keySet()) {
////            List<Integer> list = map.get(key);
////            for (int i = list.size() - 1; i >= 0; i--) {
////                res[index++] = list.get(i);
////            }
////        }
////        return res;
////    }
////}
////class Solution {
////    public int[] findDiagonalOrder(int[][] matrix) {
////        if(matrix.length == 0 || matrix[0].length == 0) return new int[0];
////        Map<Integer, LinkedList<Integer>> map = new LinkedHashMap<>();
////        int m = matrix.length, n = matrix[0].length;
////        for(int i = 0; i < m; i++){
////            for(int j = 0; j < n; j++){
////                if(map.containsKey(i+j)){
////                    if((i + j) % 2 == 0){
////                        map.get(i+j).addLast(matrix[i][j]);
////                    }else{
////                        map.get(i+j).addFirst(matrix[i][j]);
////                    }
////                }else{
////                    LinkedList<Integer> list = new LinkedList<>();
////                    list.add(matrix[i][j]);
////                    map.put(i+j, list);
////                }
////            }
////        }
////        int[] res = new int[m * n];
////        int index = 0;
////        for(Integer key : map.keySet()){
////            List<Integer> list = map.get(key);
////            int size = list.size();
////            for(int i = 0; i < size; i++){
////                res[index++] = list.get(i);
////            }
////        }
////        return res;
////    }
////}
////class Solution {
////    public static int minPathSum(int[][] grid) {
////        if(grid.length == 0 || grid[0].length == 0) return 0;
////        int m = grid.length, n = grid[0].length;
////        int[][] dp = new int[m+1][n+1];
////        for(int i = m - 1; i >= 0; i--){
////            for(int j = n - 1; j >= 0; j--){
////                dp[i][j] = Math.min(dp[i+1][j], dp[i][j+1]) + grid[i][j];
////                System.out.println(dp[i][j]);
////            }
////        }
////        return dp[0][0];
////    }
////    public static void main(String[] args) {
////        int[][] p = {{1,3,1},{1,5,1},{4,2,1}};
////        int ans = minPathSum(p);
////        System.out.println(ans);
////    }
////}
//
//
////class Solution {
////    public static int findRepeatNumber(int[] nums) {
////        int n = nums.length;
////        for(int i = 0; i < n; i++){
////            while(nums[i] != i){
////                if(nums[i] == nums[nums[i]]){
////                    return nums[i];
////                }
////                int tmp = nums[i];
////                nums[i] = nums[nums[i]];
////                nums[nums[i]] = tmp;
////
////                //int tmp = nums[nums[i]];
////                //nums[nums[i]] = nums[i];
////                //nums[i] = tmp;
////            }
////        }
////        return -1;
////    }
////
////    public static void main(String[] args) {
////        int[] p = {2, 3, 1, 0, 2, 5, 3};
////        int number = findRepeatNumber(p);
////        System.out.println(number);
////    }
////}
//
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode() {
//    }
//
//    ListNode(int val) {
//        this.val = val;
//    }
//
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//
//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode pre = new ListNode(0);
//        ListNode cur = pre;
//        int carry = 0;
//        while (l1 != null || l2 != null){
//            int x = l1 == null ? 0 : l1.val;
//            int y = l2 == null ? 0 : l2.val;
//            int sum = x + y + carry;
//            carry = sum % 10;
//            sum = sum / 10;
//            cur.next = new ListNode(sum);
//            cur = cur.next;
//            if (l1 != null){
//                l1 = l1.next;
//            }
//            if (l2 != null){
//                l2 = l2.next;
//            }
//        }
//        if (carry == 1){
//            cur.next = new ListNode(carry);
//        }
//        return pre.next;
//    }
//}
//
//
//class Solution {
//    public int maxArea(int[] height) {
//        int l = 0, r = height.length - 1;
//        int res = 0;
//        while(l < r){
//            int area = (r - l) * Math.min(height[l], height[r]);
//            res = Math.max(area, res);
//            if(height[l] <= height[r]){
//                l++;
//            }else{
//                r--;
//            }
//        }
//        return res;
//    }
//}
//
//
//class Solution {
//    public static int threeSumClosest(int[] nums, int target) {
//        int res = nums[0]+nums[1]+nums[2];
//        Arrays.sort(nums);
//        for (int i = 0; i < nums.length; i++) {
//            if (i > 0 &&nums[i] == nums[i - 1] ){
//                continue;
//            }
//            int l = i + 1, r = nums.length - 1;
//            while (l < r){
//                int sum = nums[i]+nums[l]+nums[r];
//                if (Math.abs(target - sum) < Math.abs(res - target)){
//                    res = sum;
//                }
//                if (sum == target){
//                    return sum;
//                }else if (sum < target){
//                    l++;
//                    while (l < r && nums[l] == nums[l - 1]){
//                        l++;
//                    }
//                }else {
//                    r--;
//                    while (l < r && nums[r] == nums[r + 1]){
//                        r--;
//                    }
//                }
//            }
//        }
//        return res;
//    }
//}
//
//class Solution {
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2){
//            return s;
//        }
//        char[] charArray = s.toCharArray();
//        int begin = 0;
//        int maxLen = 1;
//        for (int i = 0; i < len - 1; i++) {
//            for (int j = i + 1; j < len; j++) {
//                if (j - i + 1 > maxLen && fun(charArray, i, j)){
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }
//
//    boolean fun(char[] charArray, int left, int right){
//        while (left < right){
//            if (charArray[left] != charArray[right]){
//                return false;
//            }
//            left++;
//            right--;
//        }
//        return true;
//    }
//}
//
//class Solution {
//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len < 2){
//            return s;
//        }
//        int maxLen = 1;
//        int begin = 0;
//        boolean[][] dp = new boolean[len][len];
//        char[] charArray = s.toCharArray();
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//        }
//        for (int i = 1; i < len; i++) {
//            for (int j = 0; j < i; j++) {
//                if (charArray[i] != charArray[j]){
//                    dp[i][j] = false;
//                }else {
//                    if (i - j < 3){
//                        dp[i][j] = true;
//                    }else {
//                        dp[i][j] = dp[i - 1][j + 1];
//                    }
//                }
//                if (dp[i][j] && i - j + 1 > maxLen){
//                    maxLen = j - i + 1;
//                    begin = i;
//                }
//            }
//        }
//        return s.substring(begin, begin + maxLen);
//    }
//}