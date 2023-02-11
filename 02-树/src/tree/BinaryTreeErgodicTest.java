package tree;

import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/10/17:12
 * @Description:
 */
public class BinaryTreeErgodicTest {
    public static void main(String[] args) {
        BinaryTree<String, Integer> tree = new BinaryTree<>();
        tree.put("E", 5);
        tree.put("B", 5);
        tree.put("G", 5);
        tree.put("A", 5);
        tree.put("D", 5);
        tree.put("F", 5);
        tree.put("H", 5);
        tree.put("C", 5);

        Queue<String> preOrder = tree.preErgodic();
        for (String key : preOrder) {
            Integer value = tree.get(key);
            System.out.println(key + "----" + value);
        }
        System.out.println("---------------------------------------");
        Queue<String> midOrder = tree.midErgodic();
        for (String key : midOrder) {
            Integer value = tree.get(key);
            System.out.println(key + "----" + value);
        }
        System.out.println("---------------------------------------");
        Queue<String> postOrder = tree.postErgodic();
        for (String key : postOrder) {
            Integer value = tree.get(key);
            System.out.println(key + "----" + value);
        }
        System.out.println("---------------------------------------");
        Queue<String> layerOrder = tree.layerErgodic();
        for (String key : layerOrder) {
            Integer value = tree.get(key);
            System.out.println(key + "----" + value);
        }

        int depth = tree.maxDepth();
        System.out.println("二叉树深度：" + depth);
    }
}
