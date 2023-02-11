/**
 * @author Shan
 * @Description
 * @create 2021-04-28 14:21
 */
class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;
    public TreeNode(int value) {
        this.value = value;
    }
}

public class BinaryTree {
    TreeNode root;
    class TreeNode {
        int value;
        TreeNode left;
        TreeNode right;
        public TreeNode(int paraValue) {
            this.value = paraValue;
        }
    }

    public BinaryTree(int[] array) {
        root = createBinaryTreeByArray(array, 0);
    }

    private TreeNode createBinaryTreeByArray(int[] array, int index) {
        TreeNode tn = null;
        if (index < array.length) {
            int value = array[index];
            tn = new TreeNode(value);
            tn.left = createBinaryTreeByArray(array, 2 * index + 1);
            tn.right = createBinaryTreeByArray(array, 2 * index + 2);
            return tn;
        }
        return tn;
    }

}