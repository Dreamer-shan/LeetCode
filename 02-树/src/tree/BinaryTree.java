package tree;

import javax.xml.namespace.QName;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/10/16:13
 * @Description:
 */
public class BinaryTree<Key extends Comparable<Key>, Value> {
    private Node root;
    private int N;

    private class Node {
        public Key key;
        private Value value;
        public Node left;
        public Node right;

        public Node(Key key, Value value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    public int size() {
        return N;
    }

    // 添加元素
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    // 向指定的树x中添加元素并返回添加元素后新的树
    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            N++;
            return new Node(key, value, null, null);
        }

        // x结点的键 x.key 和 key 的大小比较
        int cmp = key.compareTo(x.key);
        // key > x.key,往右子树递归
        if (cmp > 0) {
            x.right = put(x.right, key, value);
            // key < x.key,往左子树递归
        } else if (cmp < 0) {
            x.left = put(x.left, key, value);
            // key == x.key,替换
        } else {
            x.value = value;
        }
        return x;
    }

    // 查询树中指定key对应的value
    public Value get(Key key) {
        return get(root, key);
    }

    // 查询树x中指定key对应的value
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            return get(x.right, key);
        } else if (cmp < 0) {
            return get(x.left, key);
        } else {
            return x.value;
        }
    }

    // 删除树中key对应的value
    public void delete(Key key) {
        delete(root, key);
    }

    // 删除指定树x中key对应的value，返回删除后的新树
    public Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp > 0) {
            // 新树成为x的右结点
            x.right = delete(x.right, key);
        } else if (cmp < 0) {
            // 新树成为x的左结点
            x.left = delete(x.left, key);
        } else {
            // 找到右子树中最小节点
            // 删除操作，注意先将N-1
            N--;
            // 如果x没有右子树，返回x的左子树
            if (x.right == null){
                return x.left;
            }
            // 如果x没有左子树，返回x的右子树
            if (x.left == null){
                return x.right;
            }

            Node minNode = x.right;
            while (minNode.left != null){
                minNode = minNode.left;
            }

            // 删除右子树中最小的结点
            Node n = x.right;
            while (n.left != null){
                if (n.left.left == null){
                    n.left = null;
                }else {
                    n = n.left;
                }
            }

            // 让x结点的左子树成为minNode的左子树
            minNode.left = x.left;
            // 让x结点的右子树成为minNode的右子树
            minNode.right = x.right;
            // 让minNode代替x
            x = minNode;

            // N--放这里有可能不会执行
            // N--
        }
        return x;
    }

    // 查找整个树中最小的键
    public Key min(){
        // min(root)是最小键所在的结点，min(root).key就是最小的键
        return min(root).key;
    }

    // 在指定树x中找到最小的键所在的结点
    private Node min(Node x){
        // x是否有左结点，有则继续向左查找，如果没有，x就是最小键所在的结点
        if (x.left != null){
            return min(x.left);
        }else
            return x;
    }

    public Key max(){

        return max(root).key;
    }
    private Node max(Node x){
        if (x.right != null){
            return max(x.right);
        }else {
            return x;
        }
    }
    public Queue<Key> preErgodic(){
        Queue<Key> keys = new LinkedList<>();
        preErgodic(root, keys);
        return keys;
    }

    private void preErgodic(Node x, Queue<Key> keys){
        if (x == null){
            return;
        }
        keys.add(x.key);
        if (x.left != null){
            preErgodic(x.left, keys);
        }
        if (x.right != null){
            preErgodic(x.right, keys);
        }
    }

    // 中序
    public Queue<Key> midErgodic(){
        Queue<Key> keys = new LinkedList<>();
        midErgodic(root, keys);
        return keys;
    }

    private void midErgodic(Node x, Queue<Key> keys){
        if (x == null){
            return;
        }
        if (x.left != null){
            midErgodic(x.left, keys);
        }
        keys.add(x.key);
        if (x.right != null){
            midErgodic(x.right, keys);
        }
    }

    // 后序
    public Queue<Key> postErgodic(){
        Queue<Key> keys = new LinkedList<>();
        postErgodic(root, keys);
        return keys;
    }

    private void postErgodic(Node x, Queue<Key> keys){
        if (x == null){
            return;
        }
        if (x.left != null){
            postErgodic(x.left, keys);
        }
        if (x.right != null){
            postErgodic(x.right, keys);
        }
        keys.add(x.key);
    }

    // 层次
    public Queue<Key> layerErgodic(){
        Queue<Key> keys = new LinkedList<>();
        Queue<Node> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()){
            Node n = nodes.poll();
            keys.add(n.key);
            if (n.left != null){
                nodes.add(n.left);
            }
            if (n.right != null){
                nodes.add(n.right);
            }
        }
        return keys;
    }

    // 最大深度
    public int maxDepth(){
        return maxDepth(root);
    }

    public int maxDepth(Node x){
        if (x == null){
            return 0;
        }
        int max = 0, maxL = 0, maxR = 0;
        if (x.left != null){
            maxL = maxDepth(x.left);
        }
        if (x.right != null){
            maxR = maxDepth(x.right);
        }
        return Math.max(maxL, maxR) + 1;
    }


}
