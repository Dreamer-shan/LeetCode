package 二叉树第k大的节点;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Shan
 * @Description
 * @create 2021-01-27 14:32
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    int ans = 0, count = 0;
    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }
    void inorder(TreeNode root, int k){
        if (root == null)   return;
        // 右
        inorder(root.right, k);
        // 根
        if (++count == k){
            ans = root.val;
            // 提前结束
            return;
        }
        // 左
        inorder(root.left, k);
    }

    public int kthLargest2(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (!stack.isEmpty() || root != null){
            while(root != null){
                stack.push(root);
                root = root.right;
            }
            root = stack.peek();
            stack.pop();
            if (--k == 0)   return root.val;
            root = root.left;
        }
        return 0;
    }


    public int kthLargest3(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        return list.get(list.size() - k);
    }
    public List<Integer> inOrder(TreeNode root, List<Integer> list){
        if (root == null) return list;
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
        return list;
    }


}
