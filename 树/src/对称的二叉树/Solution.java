package 对称的二叉树;

import java.util.LinkedList;

/**
 * @author Shan
 * @Description
 * @create 2021-01-27 16:04
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null)   return true;
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode L, TreeNode R){
        // 如果左右同时越过叶子节点
        if (L == null && R == null) return true;
        // 如果左右只有一个越过叶子节点 或者 左右值不相等
        if (L == null || R== null || L.val != R.val)    return false;
        return helper(L.left, R.right) && helper(L.right, R.left);
    }

    public boolean isSymmetric2(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if (root == null)   return true;
        // 左右子树头节点接入队列
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()){
            // 弹出左右节点
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            // 同时越过叶子节点，返回true
            if (leftNode == null && rightNode == null)  continue;
            // 只有一个越过叶子节点，或者值不相等，false
            if (leftNode == null ||
                    rightNode == null || leftNode.val != rightNode.val)
                return false;

            // 将左节点的左子树和右节点的右子树入队
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            // 将左节点的右子树和右节点的左子树入队
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    public boolean isSymmetric3(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        if (root == null)   return true;
        // 左右子树头节点接入栈
        stack.push(root.left);
        stack.push(root.right);
        while (!stack.isEmpty()){
            TreeNode leftNode = stack.pop();
            TreeNode rightNode = stack.pop();
            if (leftNode == null && rightNode == null)  continue;
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val) return false;
            stack.push(leftNode.left);
            stack.push(rightNode.right);

            stack.push(leftNode.right);
            stack.push(rightNode.left);
        }
        return true;
    }
}
