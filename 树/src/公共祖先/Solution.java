package 公共祖先;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shan
 * @Description
 * @create 2021-01-28 9:33
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> path1 = getPath(root, p);
        List<TreeNode> path2 = getPath(root, q);

        TreeNode ancestor = null;
        // 两条路径中最后一个相同的节点就是共同祖先
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            if (path1.get(i) == path2.get(i)) {
                ancestor = path1.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    public List<TreeNode> getPath(TreeNode root, TreeNode target) {
        TreeNode node = root;
        List<TreeNode> path = new ArrayList<>();
        while (node != target) {
            path.add(node);
            if (target.val < node.val) { // target在node的左子树
                node = node.left;
            } else if (target.val > node.val) {   // target在node的右子树
                node = node.right;
            } else {    // target == node跳出
                break;
            }
        }
        path.add(node); // 把target加入路径中
        return path;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        while (true) {
            if (p.val < ancestor.val && q.val < ancestor.val) { //p q 都在左子树
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val && q.val > ancestor.val) {  //p q 都在右子树
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        if (p.val < ancestor.val && q.val < ancestor.val) {
            return lowestCommonAncestor3(ancestor.left, p, q);
        }
        if (p.val > ancestor.val && q.val > ancestor.val) {
            return lowestCommonAncestor3(ancestor.right, p, q);
        }
        return ancestor;
    }



    public TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ancestor = root;
        if (p.val > q.val) {    // 使 p.val < q.val
            TreeNode tmp = p;
            p = q;
            q = tmp;
        }
        while (true) {
            if (q.val < ancestor.val) {     // 大的值 < ancestor.val  在左子树
                ancestor = ancestor.left;
            } else if (p.val > ancestor.val) {  // 小的值 > ancestor.val  在右子树
                ancestor = ancestor.right;
            } else {
                break;
            }
        }
        return ancestor;
    }
}