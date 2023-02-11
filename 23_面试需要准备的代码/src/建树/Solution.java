package 建树;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/02/13:48
 * @Description:
 */
class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
    public TreeNode(TreeNode left, TreeNode right, int val){
        this.left = left;
        this.right = right;
        this.val = val;
    }
}
public class Solution {
    public static void main(String[] args) {
        int[] num = {1,2,3};
        TreeNode root = buildTree(num, 0);
        print(root);
        System.out.println();
        preOrder(root);

    }

    public static void print(TreeNode root){
        if (root == null)   return;
        TreeNode node = root;
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = queue.poll();
                list.add(temp.val);
                if (temp.left != null)  queue.offer(temp.left);
                if (temp.right != null)  queue.offer(temp.right);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
    }
    public static TreeNode buildTree(int[] nums, int i){
        if (i >= nums.length || nums.length == 0)   return null;
        TreeNode root = new TreeNode(nums[i]);
        root.left = buildTree(nums, 2 * i + 1);
        root.right = buildTree(nums, 2 * i + 2);
        return root;
    }

    public static List<Integer> preOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)   return res;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);    // 根
                res.add(cur.val);   // 处理根
                cur = cur.left;     // 左
            }else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        return res;
    }

    public static List<Integer> inOrder(TreeNode root){
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null)   return res;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()){
            if (cur != null){
                stack.push(cur);
                cur = cur.left;     // 左
            }else {
                cur = stack.pop();
                res.add(cur.val);   // 根
                cur = cur.right;    // 右
            }
        }
        for (int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
        return res;
    }
}