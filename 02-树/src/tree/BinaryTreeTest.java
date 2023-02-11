package tree;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/10/17:12
 * @Description:
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        BinaryTree<Integer, String> tree = new BinaryTree<>();
        tree.put(1,"张三");
        tree.put(2,"李四");
        tree.put(3,"王五");
        System.out.println("插入后的元素个数：" + tree.size());

        System.out.println("键2对应的元素：" + tree.get(2));

        tree.delete(3);
        System.out.println("删除后的元素个数：" + tree.size());
        System.out.println("删除键3对应的元素：" + tree.get(3));
        System.out.println("元素个数：" + tree.size());
    }
}
