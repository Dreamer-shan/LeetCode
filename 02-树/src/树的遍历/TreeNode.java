package 树的遍历;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/03/08/21:12
 * @Description:
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    public TreeNode(int x, TreeNode l, TreeNode r) {
        val = x;
        this.left = l;
        this.right = r;
    }
}

class Solution {
    public List<Integer> preorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    // 递归版本
    public void preorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        res.add(root.val);
        preorder(root.left, res);
        preorder(root.right, res);
    }

    // 迭代版本
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();

        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if(cur != null){
                s.push(cur);
                res.add(cur.val);
                cur = cur.left;
            }else {
                cur = s.pop();
                cur = cur.right;
            }
        }
        return res;
    }


    public List<Integer> inorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorder(root, res);
        return res;
    }

    // 递归版本
    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) return;
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }


    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()) {
            if (cur != null) {
                s.push(cur);
                cur = cur.left;
            } else {
                cur = s.pop();
                res.add(cur.val);
                cur = cur.right;
            }
        }
        return res;
    }


    public List<Integer> postorderTraversal1(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        if(root == null){
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }

    // 前序遍历顺序为：根 -> 左 -> 右
    // 后序遍历顺序为：左 -> 右 -> 根
    // 所以, 我们可以把前序遍历的稍作修改: 根 -> 右 -> 左,
    // 然后结果存放到栈里进行倒序, 之后再遍历结果栈就可以输出后序遍历了
    public List<Integer> postorderTraversal2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Deque<TreeNode> s = new ArrayDeque<>();
        Deque<TreeNode> resStack = new ArrayDeque<>();
        TreeNode cur = root;
        while (cur != null || !s.isEmpty()){
            if (cur != null){
                resStack.push(cur);
                s.push(cur);
                cur = cur.right;
            }else {
                cur = s.pop();
                cur = cur.left;
            }
        }
        while (!resStack.isEmpty()){
            res.add(resStack.pop().val);
        }
        return res;
    }
}





