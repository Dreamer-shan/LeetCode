package 建树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/04/9:30
 * @Description:
 */
class TreeNode {
    TreeNode left;
    TreeNode right;
    int val;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }
}

public class Solution {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6,7,787,8,89,1};
        TreeNode root = buildTree(arr, 0);
        List<Integer> levelOrder = levelOrder(root);
        System.out.println(levelOrder);
        List ans = new ArrayList();
        preOrder(root, ans);
        System.out.println(ans);
    }
    public static TreeNode buildTree(int[] arr, int i){
        if(i >= arr.length || arr.length == 0) return null;
        TreeNode root = new TreeNode(arr[i]);
        root.left = buildTree(arr, 2 * i + 1);
        root.right = buildTree(arr, 2 * i + 2);
        return root;
    }
    public static List<Integer> levelOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null)   return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null)  queue.offer(node.left);
            if (node.right != null)  queue.offer(node.right);
        }
        return ans;
    }

    public static void preOrder(TreeNode root, List<Integer> ans){

        if (root == null)   return ;
        ans.add(root.val);
        preOrder(root.left, ans);
        preOrder(root.right, ans);
    }
}
