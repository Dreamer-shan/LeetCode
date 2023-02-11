package 锯齿层次遍历;

import 树的遍历.TreeNode;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/03/11/13:21
 * @Description:
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null)    return res;
        int k = 0;
        queue.offer(root);
        while(!queue.isEmpty()){
            k++;
            List<Integer> temp = new ArrayList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left != null)   queue.offer(node.left);
                if(node.right != null)   queue.offer(node.right);
            }
            if(k % 2 == 1){
                res.add(temp);
            }else{
                Collections.reverse(temp);
                res.add(temp);
            }
        }
        return res;
    }
}