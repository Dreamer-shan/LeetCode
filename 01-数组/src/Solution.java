//import javax.swing.tree.TreeNode;
//import java.util.*;
//
////import javax.sound.sampled.EnumControl;
////import javax.swing.tree.TreeNode;
////import java.util.*;
////
//////class Solution {
//////    public static int[][] merge(int[][] intervals) {
//////        if (intervals.length == 0) return new int[0][2];
//////        List<int[]> res = new ArrayList<>();
//////        Arrays.sort(intervals, new Comparator<int[]>() {
//////            @Override
//////            public int compare(int[] o1, int[] o2) {
//////                return o1[0] - o2[0];
//////            }
//////        });
//////        int left = intervals[0][0];
//////        int right = intervals[0][1];
//////        for (int i = 1; i < intervals.length; i++) {
//////            if (intervals[i][0] > right) {
//////                res.add(new int[]{left, right});
//////                left = intervals[i][0];
//////                right = intervals[i][1];
//////            }
//////            else right = Math.max(right, intervals[i][1]);
//////        }
//////        res.add(new int[]{left,right});
//////        return res.toArray(new int[][]{});
//////    }
//////
//////    public static void main(String[] args) {
//////        int[][] a = {{1,3},{2,6},{8,10},{15,18}};
//////        int[][] merge = merge(a);
//////        for (int[] ints : merge) {
//////            for (int i : ints) {
//////                System.out.println(i);
//////            }
//////        }
//////    }
//////}
////
//////class Solution {
//////    public int[][] merge(int[][] intervals) {
//////        if (intervals.length == 0) return new int[0][];
//////        List<int[]> res = new ArrayList<>();
//////        Arrays.sort(intervals, new Comparator<int[]>() {
//////            @Override
//////            public int compare(int[] o1, int[] o2) {
//////                return o1[0] - o2[0];
//////            }
//////        });
//////        int left = intervals[0][0];
//////        int right = intervals[0][1];
//////        for (int i = 1; i < intervals.length; i++) {
//////            if (intervals[i][0] > right){
//////                res.add(new int[]{left, right});
//////                left = intervals[i][0];
//////                right = intervals[i][1];
//////            }else {
//////                right = Math.max(right, intervals[i][1]);
//////            }
//////        }
//////        res.add(new int[]{left, right});
//////        return res.toArray(new int[][]{});
//////    }
//////}
////
////
//////class Solution {
//////    public int search(int[] nums, int target) {
//////        if (nums.length == 0) return -1;
//////        if (nums.length == 1) {
//////            return nums[0] == target ? 0 : -1;
//////        }
//////        int l = 0, r = nums.length - 1;
//////        while (l <= r){
//////            int mid = l + ( r- l) / 2;
//////            if (mid == target)  return mid;
//////            if (nums[0] <= nums[mid]){
//////                if (target >= nums[0] && target < nums[mid]){
//////                    r = mid - 1;
//////                }else {
//////                    l = mid + 1;
//////                }
//////            }else {
//////                if (target > nums[mid] && target <= nums[nums.length - 1]){
//////                    r = mid - 1;
//////                }else {
//////                    l = mid + 1;
//////                }
//////            }
//////        }
//////        return -1;
//////    }
//////}
////
//////
//////class Solution {
//////    public int getWinner(int[] arr, int k) {
//////        int prev = Math.max(arr[0], arr[1]);
//////        if (k == 1) return prev;
//////        int consecutive = 1;
//////        int maxNum = prev;
//////        for (int i = 2; i < arr.length; i++) {
//////            if (arr[i] < prev){
//////                consecutive++;
//////                if (consecutive == k){
//////                    return prev;
//////                }
//////            }else {
//////                consecutive = 1;
//////                prev = arr[i];
//////            }
//////            maxNum = Math.max(arr[i], maxNum);
//////        }
//////        return maxNum;
//////    }
//////}
////
////
//////class Solution {
//////    public int numberOfArithmeticSlices(int[] A) {
//////        int n = A.length;
//////        if(n < 3)   return 0;
//////        int[] dp = new int[n+1];
//////        int sum = 0;
//////        for(int i = 2; i < n; i++){
//////            if(A[i] - A[i - 1] == A[i - 1] - A[i - 2]){
//////                dp[i] = dp[i - 1] + 1;
//////                sum += dp[i];
//////            }
//////        }
//////        return sum;
//////    }
//////}
////
////
////class Solution {
////    public static double myPow(double x, int n) {
////        double ans = 1.0;
////        if (n == 0) {
////            return 1;
////        } else if (n > 0) {
////            for (int i = 0; i < n; i++) {
////                ans *= x;
////            }
////        } else {
////            for (int i = 0; i < -n; i++) {
////                ans /= x;
////            }
////        }
////        return ans;
////    }
////
////    public static void main(String[] args) {
////        System.out.println(myPow(2, -2));
////    }
////}
////
////class Solution {
////    public List<List<Integer>> levelOrder(TreeNode root) {
////        List<List<Integer>> ans = new ArrayList<>();
////        Queue<TreeNode> queue = new LinkedList<>();
////        if (root == null) return ans;
////        queue.add(root);
////        int level = 1;
////        while (!queue.isEmpty()) {
////            LinkedList<Integer> temp = new LinkedList<>();
////            int size = queue.size();
////            if (level % 2 != 0) {
////                for (int i = 0; i < size; i++) {
////                    TreeNode node = queue.poll();
////                    temp.add(node.val);
////                    if (node.left != null) queue.add(node.left);
////                    if (node.right != null) queue.add(node.rihgt);
////                }
////            } else {
////                for (int i = 0; i < size; i++) {
////                    TreeNode node = queue.poll();
////                    temp.add(node.val);
////                    if (node.left != null) queue.add(node.left);
////                    if (node.right != null) queue.add(node.rihgt);
////                }
////            }
////            level++;
////            ans.add(temp);
////        }
////
////    }
////}
////
////
////class Solution {
////    public List<List<Integer>> levelOrder(TreeNode root) {
////        Queue<TreeNode> queue = new LinkedList<>();
////        List<List<Integer>> res = new ArrayList<>();
////        if (root != null) queue.add(root);
////        int layer = 1;
////        while (!queue.isEmpty()) {
////            LinkedList<Integer> tmp = new LinkedList<>();
////            for (int i = queue.size(); i > 0; i--) {
////                TreeNode node = queue.poll();
////                if (layer % 2 != 0) tmp.addLast(node.val);
////                else tmp.addFirst(node.val);
////                if (node.left != null) queue.add(node.left);
////                if (node.right != null) queue.add(node.right);
////            }
////            layer++;
////            res.add(tmp);
////        }
////        return res;
////    }
////}
////
////
////class Solution {
////    public double myPow(double x, int n) {
////        if (x == 0) return 0;
////        if (n == 0) return 1;
////        if (n < 0) return pow(1 / x, -n);
////        return pow(x, n);
////
////    }
////
////    double pow(double x, int n) {
////        if (n == 0) return 1;
////        if (n % 2 == 0) {
////            double ans = pow(x, n / 2);
////            return ans * ans;
////        } else {
////            double ans = pow(x, n / 2);
////            return x * ans * ans;
////        }
////
////    }
////}
////
////class Solution {
////    public double myPow(double x, int n) {
////        long N = n;
////        if (x == 0)
////            return 0;
////        if (N >= 0)
////            return power(x, N);
////
////        //n<0时，x^n即求(1/x)^(-n)
////        return power(1 / x, -N);
////    }
////
////    //递归方式的快速幂
////    public double power(double x, long n) {
////        if (n == 0) {
////            return 1;
////        }
////        double r = power(x, n / 2);
////
////        //n&1判断n最低为是否为1，为1则n为奇数，为0则n为偶数（其实就是n%2）
////        //指数n为奇数，则需要多乘一个底数。因为上行代码计算n/2时，若n为奇数，精度丢失向下取整（相当于少乘一个x）
////        if ((n & 1) == 1) {
////            return r * r * x;
////        } else {
////            return r * r;
////        }
////    }
////}
////class Solution {
////    public static boolean isSubStructure(TreeNode A, TreeNode B) {
////        if (A == null || B == null)
////            return false;
////        //先从根节点判断B是不是A的子结构，如果不是再分别判断B是不是A的两个子树的子结构
////        //只要有一个为true，就说明B是A的子结构
////        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
////    }
////
////    static boolean isSub(TreeNode A, TreeNode B) {
////        //这里如果B为空，说明B已经访问完了，确定是A的子结构
////        if (B == null)
////            return true;
////        //如果B不为空A为空，或者这两个节点值不同，说明B树不是
////        //A的子结构，直接返回false
////        if (A == null || A.val != B.val)
////            return false;
////        //当前节点比较完之后还要继续判断左右子节点
////        return isSub(A.left, B.left) && isSub(A.right, B.right);
////    }
////}
////
////
////
////
//class Solution {
//    public boolean isNumber(String s) {
//        if (s == null || s.length() == 0) return false;
//        boolean numSeen = false;
//        boolean dotSeen = false;
//        boolean eSeen = false;
//        char[] str = s.toCharArray();
//        for (int i = 0; i < str.length; i++) {
//            if (str[i] >= '0' && str[i] <= '9') {
//                numSeen = true;
//            } else if (str[i] == '.') {
//                if (eSeen || dotSeen) {
//                    return false;
//                }
//                dotSeen = true;
//            } else if (str[i] == 'e' || str[i] == 'E') {
//                if (eSeen || !numSeen) {
//                    return false;
//                }
//                eSeen = true;
//                numSeen = true;
//            } else if (str[i] == '-' || str[i] == '+') {
//                //+-出现不在0位置，也不在e/E的后面第一个位置
//                if (i != 0 && str[i - 1] != 'e' && str[i - 1] != 'E') {
//                    return false;
//                }
//            } else {
//                return false;
//            }
//        }
//        return numSeen;
//    }
//}
//
//
//class Solution {
//    public Node copyRandomList(Node head) {
//        Node cur = head;
//        Node dum = new Node(0), pre = dum;
//        while (cur != null) {
//            Node node = new Node(cur.val); // 复制节点 cur
//            pre.next = node;               // 新链表的 前驱节点 -> 当前节点
//            // pre.random = "???";         // 新链表的 「 前驱节点 -> 当前节点 」 无法确定
//            cur = cur.next;                // 遍历下一节点
//            pre = node;                    // 保存当前新节点
//        }
//        return dum.next;
//    }
//
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//        Node cur = head;
//        Map<Node, Node> map = new HashMap<>();
//        while (cur != null) {
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//        while (cur != null) {
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//    }
//}
//
///**
// * Definition for a binary tree node.
// * public class TreeNode {
// * int val;
// * TreeNode left;
// * TreeNode right;
// * TreeNode(int x) { val = x; }
// * }
// */
//class Solution {
//    public TreeNode mirrorTree(TreeNode root) {
//        if (root == null) return null;
//        TreeNode left = mirrorTree(root.right);
//        TreeNode right = mirrorTree(root.left);
//        root.left = left;
//        root.right = right;
//        return root;
//    }
//}
//
//class Solution {
//    public Node copyRandomList(Node head) {
//        if (head == null)   return head;
//        Node cur = head;
//
//        while(cur != null){
//            Node temp = new Node(cur.val);
//            temp.next = cur.next;
//            cur.next = temp;
//            cur = cur.next;
//        }
//
//        cur = head;
//        while (cur != null){
//            if (cur.random != null){
//                cur.next.random = cur.random.next;
//            }
//            cur = cur.next.next;
//        }
//
//        cur = head.next;
//        Node prev = head, res = head.next;
//        while(cur.next != null){
//            cur.next = cur.next.next;
//            prev.next = prev.next.next;
//        }
//        prev.next = null;
//        return res;
//    }
//}
//
//
//class Solution {
//    public Node copyRandomList(Node head) {
//        if(head == null) return null;
//        Node cur = head;
//        // 1. 复制各节点，并构建拼接链表
//        while(cur != null) {
//            Node tmp = new Node(cur.val);
//            tmp.next = cur.next;
//            cur.next = tmp;
//            cur = tmp.next;
//        }
//        // 2. 构建各新节点的 random 指向
//        cur = head;
//        while(cur != null) {
//            if(cur.random != null)
//                cur.next.random = cur.random.next;
//            cur = cur.next.next;
//        }
//        // 3. 拆分两链表
//        cur = head.next;
//        Node pre = head, res = head.next;
//        while(cur.next != null) {
//            pre.next = pre.next.next;
//            cur.next = cur.next.next;
//            pre = pre.next;
//            cur = cur.next;
//        }
//        pre.next = null; // 单独处理原链表尾节点
//        return res;      // 返回新链表头节点
//    }
//}
//
//class Solution {
//    public Node copyRandomList(Node head) {
//        if (head == null)   return null;
//        HashMap<Node, Node> map = new HashMap<Node, Node>();
//        Node cur = head;
//        while(cur != null){
//            map.put(cur, new Node(cur.val));
//            cur = cur.next;
//        }
//        cur = head;
//        while (cur != null){
//            map.get(cur).next = map.get(cur.next);
//            map.get(cur).random = map.get(cur.random);
//            cur = cur.next;
//        }
//        return map.get(head);
//    }
//}
//
//
//
//class Solution {
//    public TreeNode mirrorTree(TreeNode root) {
//        if(root == null)    return null;
//        TreeNode left = mirrorTree(root.right);
//        TreeNode right = mirrorTree(root.left);
//        root.left = left;
//        root.right = right;
//        return root;
//    }
//}
//
//class Solution {
//    public TreeNode mirrorTree(TreeNode root) {
//        if(root == null) return null;
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            if (node.left != null)  stack.push(node.left);
//            if (node.right != null) stack.push(node.right);
//            TreeNode temp = node.left;
//            node.left = node.right;
//            node.right = temp;
//        }
//        return root;
//    }
//}
//
//
//class Solution {
//    public TreeNode mirrorTree(TreeNode root) {
//        if(root == null)    return null;
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        stack.push(root);
//        while (!stack.isEmpty()){
//            TreeNode node = stack.pop();
//            if (root.left != null)  stack.push(root.left);
//            if (root.right != null) stack.push(root.right);
//
//            TreeNode temp = node.left;
//            node.left = node.right;
//            node.right = temp;
//        }
//        return root;
//    }
//}
//
//class Solution {
//    public int minArray(int[] numbers) {
//        int len = numbers.length;
//        int l = 0, r = len - 1;
//        while (l < r){
//            int mid = l + (r - l) / 2;
//            if (numbers[mid] < numbers[r]){
//                r = mid + 1;
//            }else if (numbers[mid] > numbers[r]){
//                l = mid + 1;
//            }else {
//                r -= 1;
//            }
//        }
//        return numbers[l];
//    }
//}
//
//class Solution {
//    List<List<Integer>> res = new LinkedList<>();
//    LinkedList<Integer> path = new LinkedList<>();
//    public List<List<Integer>> pathSum(TreeNode root, int sum) {
//        dfs(root, sum);
//        return res;
//
//    }
//
//    void dfs(TreeNode root, int sum){
//        if (root == null)   return;
//        path.add(root.val);
//        sum -= root.val;
//        if (sum == 0 && root.left == null && root.right == null){
//            res.add(new LinkedList<>(path));
//        }
//        dfs(root.left,  sum);
//        dfs(root.right,  sum);
//        path.removeLast();
//    }
//}
//

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
//        dp[0]=true 表示空串且合法
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public boolean wordBreak2(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordDictSet = new HashSet(wordDict);
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDictSet) {
                int len = word.length();
                if (i >= len && s.substring(i - len, len).equals(word)){
                    dp[i] = dp[i] || dp[i - len];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        List<String> dic = new ArrayList<>();
        dic.add("leet");
        dic.add("code");
        String s = "leetcode";
        boolean b = solution.wordBreak(s, dic);
        System.out.println(b);
    }
}

