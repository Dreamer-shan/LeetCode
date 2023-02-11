import java.util.Scanner;

/**
 * @author Shan
 * @Description
 * @create 2021-08-08 11:32
 */
class TreeNode{
     int value;
     TreeNode left;
     TreeNode right;
    public TreeNode(){}
    public TreeNode(int value){
        this.value = value;
    }
    public TreeNode(int value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
public class Test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int k = sc.nextInt();
        TreeNode root = new TreeNode(k);
        for (int i = 0; i < n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            if (left == 0 && right == 0){
                continue;
            }
            root.left = new TreeNode(left);
            root.right = new TreeNode(right);
        }
    }
}
