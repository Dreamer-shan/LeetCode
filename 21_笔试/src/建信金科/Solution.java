package 建信金科;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/09/17/19:38
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

    public static boolean fun(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null)   return true;
        q.offer(root);
        while (!q.isEmpty()){
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = q.poll();
                if (node.left != null && node.right == null)    return false;
                if (node.right != null) q.offer(node.right);
                if (node.left != null)  q.offer(node.left);
            }
        }
        return true;
    }
}