//package 树的子结构o26;
//
//import Tree.TreeNode;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * Created with IntelliJ IDEA.
// *
// * @Author: shy
// * @Date: 2021/01/10/15:03
// * @Description:
// */
//
//
////class Solution {
////    public static boolean isSubStructure(TreeNode A, TreeNode B) {
////        if (A == null || B == null)
////            return false;
////        //先从根节点判断B是不是A的子结构，如果不是在分别从左右两个子树判断，
////        //B不光有可能是A的子结构，也有可能是A左子树的子结构或者右子树的子结构，只要有一个成立就返回true
////        return isSub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
////    }
////
////    static boolean isSub(TreeNode A, TreeNode B) {
////        //这里如果B为空，说明B已经访问完了,true
////        if (B == null)
////            return true;
////        //如果B还有，但A遍历完了，或者这两个节点值不同， B 剩下的就无法匹配，false
////        if (A == null || A.val != B.val)
////            return false;
////        //当前节点比较完之后还要继续判断左右子节点
////        return isSub(A.left, B.left) && isSub(A.right, B.right);
////    }
////}
////
////class Solution {
////    Stack<Integer> stack = new Stack<Integer>();
////    public int[] reversePrint(ListNode head) {
////
////        while (head != null){
////            stack.push(head.val);
////            head = head.next;
////        }
////        int[] array = new int[stack.size()];
////        for (int i = 0; i < stack.size(); i++) {
////            array[i] = stack.pop();
////        }
////        return array;
////    }
////}
////
////
////
//// 栈
////public class Solution {
////    public int[] reversePrint(ListNode head) {
////        Stack<Integer> stack = new Stack<>();
////        while (head != null) {
////            stack.push(head.val);
////            head = head.next;
////        }
////        int size = stack.size();
////        int[] array = new int[size];
//////      for循环中不能是stack.size()，因为stack.size()会动态变化。
////        for (int i = 0; i < size; i++) {
////            array[i] = stack.pop();
////        }
////        return array;
////    }
////}
////
////class ListNode {
////    int val;
////    ListNode next;
////    ListNode(int x) {
////        val = x;
////    }
////}
////
////// 递归
////class Solution {
////    private ArrayList<Integer> tmp;
////    int[] reversePrint(ListNode head) {
////        tmp = new ArrayList<Integer>();
////        recur(head);
////        int[] res = new int[tmp.size()];
////        for(int i = 0; i < res.length; i++)
////            res[i] = tmp.get(i);
////        return res;
////    }
////     void recur(ListNode head) {
////        if(head == null) return;
////        recur(head.next);
////        tmp.add(head.val);
////    }
////
////    public static void main(String[] args) {
////        ListNode head1 = new ListNode(1);
////        ListNode head2 = new ListNode(2);
////        head1.next = head2;
////        head2.next = null;
////        Solution ss=new Solution();
////        int[] ints = ss.reversePrint(head1);
////        for (int anInt : ints) {
////            System.out.println(anInt);
////        }
////    }
////}
//
//
//class Solution {
//    public TreeNode mirrorTree(TreeNode root) {
//        LinkedList<TreeNode> stack = new LinkedList<>();
//        List<Integer> list = new ArrayList<>();
//        stack.push(root);
//        while (!stack.isEmpty()) {
//            TreeNode node = stack.pop();
//            if (node.left != null) stack.push(node.left);
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
//    public int maxDepth(TreeNode root) {
//        LinkedList<TreeNode> queue = new LinkedList<>();
//        if (root == null) return 0;
//        queue.add(root);
//        int depth = 0;
//        while (!queue.isEmpty()) {
//            depth++;
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                TreeNode node = queue.poll();
//                if (node.left != null) queue.add(node.left);
//                if (node.right != null) queue.add(node.right);
//            }
//        }
//        return depth;
//    }
//}
//
//class Solution {
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int left = maxDepth(root.left);
//        int right = maxDepth(root.right);
//
//        return Math.max(left + 1, right + 1);
//    }
//}
//
//class Solution {
//    public int maxDepth(TreeNode root) {
//        if (root == null) {
//            return 0;
//        } else {
//            int leftHeight = maxDepth(root.left);
//            int rightHeight = maxDepth(root.right);
//            return Math.max(leftHeight, rightHeight) + 1;
//        }
//    }
//}
//
//class Solution {
//    Node pre, head;
//    public Node treeToDoublyList(Node root) {
//        if(root == null) return null;
//        dfs(root);
//        head.left = pre;
//        pre.right = head;
//        return head;
//    }
//    void dfs(Node cur) {
//        if(cur == null) return;
//        dfs(cur.left);
//        if(pre != null) pre.right = cur;
//        else head = cur;
//        cur.left = pre;
//        pre = cur;
//        dfs(cur.right);
//    }
//
//    void inorder(Node root){
//        if (root == null)   return;
//        inorder(root.left);
//        if (pre == null){
//            head = root;
//        }else {
//            pre.right = root;
//            root.left = pre;
//        }
//        pre = root;
//        inorder(root.right);
//    }
//}
//
//class Solution {
//    public String replaceSpace(String s) {
//        return s.replace(" ", "%20");
//    }
//}
//
//
//class Solution {
//    List<List<Integer>> res = new LinkedList<>();
//    LinkedList<Integer> path = new LinkedList<>();
//
//
//    void dfs(TreeNode root, int sum){
//        if (root == null)   return;
//        sum -= root.val;
//        path.add(root.val);
//        if (sum == 0 && root.left == null && root.right == null){
//            res.add(new LinkedList<>(path));
//        }
//        dfs(root.left, sum);
//        dfs(root.right, sum);
//
//
//    }
//}
//
//
//class CQueue {
//    LinkedList<Integer> A, B;
//    public CQueue() {
//        A = new LinkedList<Integer>();
//        B = new LinkedList<Integer>();
//    }
//    public void appendTail(int value) {
//        A.addLast(value);
//    }
//    public int deleteHead() {
//        if(!B.isEmpty()) return B.removeLast();
//        if(A.isEmpty()) return -1;
//        while(!A.isEmpty())
//            B.addLast(A.removeLast());
//        return B.removeLast();
//    }
//}
//
//
//
//
//class CQueue {
//    LinkedList<Integer> A, B;
//    public CQueue() {
//        A = new LinkedList<>();
//        B = new LinkedList<>();
//    }
//
//    public void appendTail(int value) {
//        B.push(value);
//    }
//
//    public int deleteHead() {
//        if(!B.isEmpty())    return B.pop();
//        if(A.isEmpty())     return -1;
//        while(!A.isEmpty()){
//            B.push(A.pop());
//        }
//        return B.pop();
//    }
//}
//
