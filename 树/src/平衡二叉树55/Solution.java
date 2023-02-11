package 平衡二叉树55;

/**
 * @author Shan
 * @Description
 * @create 2021-01-28 11:05
 */


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)   return true;
        int leftHeight = treeDepth(root.left);
        int rightHeight = treeDepth(root.left);
        // 判断左子树和右子树是不是平衡的
        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int treeDepth(TreeNode root) {
        if (root == null)   return 0;
        int leftHeight = treeDepth(root.left);
        int rightHeight = treeDepth(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    public boolean isBalanced2(TreeNode root) {
        if (root == null)   return true;
        // 判断左子树和右子树是不是平衡的
        return Math.abs(treeHeight(root.left) - treeHeight(root.right)) <= 1 && isBalanced2(root.left) && isBalanced2(root.right);
    }
    public int treeHeight(TreeNode root){
        if (root == null)   return 0;
        return Math.max(treeHeight(root.left), treeHeight(root.right)) + 1;
    }
}

