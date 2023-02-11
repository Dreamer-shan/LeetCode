package 建树;

import java.util.*;

/**
 * @author Shan
 * @Description
 * @create 2021-06-03 16:42
 */
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode(){}
    public TreeNode(int val){
        this.val = val;
    }
}
public class Test {
    public static TreeNode buildTree(int[] data, int i){
        if (i >= data.length || data.length == 0){
            return null;
        }
        TreeNode root = new TreeNode(data[i]);
        root.left = buildTree(data, 2 * i + 1);
        root.right = buildTree(data, 2 * i + 2);
        return root;
    }
    public static List<Integer> levelOrder(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if (root == null)   return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode temp = queue.poll();
            ans.add(temp.val);
            if (temp.left != null){
                queue.offer(temp.left);
            }
            if(temp.right != null){
                queue.offer(temp.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8 ,9 , 10};
        TreeNode head = buildTree(arr, 0);
        List<Integer> levelOrder = levelOrder(head);
        System.out.println(levelOrder);
    }

}
