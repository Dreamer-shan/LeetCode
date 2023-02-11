package 重建二叉树7;

/**
 * @author Shan
 * @Description
 * @create 2021-01-28 16:47
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}



//class Solution{
//    public TreeNode buildTree(int[] preorder, int[] inorder){
//        return BuildTree(0, 0, inorder.length - 1, preorder, inorder);
//    }
//    public TreeNode BuildTree(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
//        // preStart > preorder.length - 1 这个条件可以不要
//        if (preStart > preorder.length - 1 || inStart > inEnd){
//            return null;
//        }
//        // 新建根节点 根节点的值初始化为 preorder[preStart]
//        TreeNode root = new TreeNode(preorder[preStart]);
//        // 在中序序列中找到根节点的索引
//        int index = 0;
//        for (int i = inStart; i <= inEnd; i++) {
//            if (inorder[i] == root.val){
//                index = i;
//                break;
//            }
//        }
//        // 左子树结点个数
//        int numLeft = index - inStart;
//        root.left = BuildTree(preStart + 1, inStart, index - 1, preorder, inorder);
//        root.right = BuildTree(preStart + 1 + numLeft, index + 1, inEnd, preorder, inorder);
//        return root;
//    }
//}


class Solution {
    int[] preorder;
    HashMap<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
        this.preorder = preorder;
        // 中序数组的 值->索引 的映射, 方便在中序数组中找到根节点(以空间换时间)
        for(int i = 0; i < inorder.length; i++)
            dic.put(inorder[i], i);
        return BuildTree(0, 0, inorder.length - 1);
    }

    TreeNode BuildTree(int pre_root, int in_left, int in_right){
        if (in_left > in_right)   return null;
        // 新建根节点 根节点的值初始化为 preorder[preStart]
        TreeNode node = new TreeNode(preorder[pre_root]);
        // 在中序序列中找到根节点的索引
        int index = dic.get(preorder[pre_root]);
        // 左子树节点的个数
        int num_left = index - in_left;
        //左子树在先序数组中的索引为pre_root + 1, 左子树在中序数组的索引是[in_left,index-1]
        node.left = BuildTree(pre_root + 1, in_left, index - 1);
        //右子树在先序数组中的索引为pre_root + 1 + 左子树个数num_left,右子树在中序数组的索引是[index+1,in_right]
        node.right = BuildTree(pre_root + 1 + num_left, index + 1, in_right);
        return node;
    }
}