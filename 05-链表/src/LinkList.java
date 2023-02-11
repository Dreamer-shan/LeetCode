import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/01/09/20:48
 * @Description: 头结点不算结点，第一个结点的索引为1
 */
public class LinkList<T> implements Iterable<T>{
    private Node head;
    private int N;

    @Override
    public Iterator<T> iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{
        private Node n;
        public LIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next != null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.val;
        }
    }

    private class Node{
        T val;
        Node next;
        public Node(T val, Node next){
            this.val = val;
            this.next = next;
        }
    }
    public LinkList(){
        this.head = new Node(null,null);
        this.N = 0;
    }
    public void clear(){
        head.next = null;
        this.N = 0;
    }
    public boolean isEmpty(){
        return N == 0;
    }

    public int length(){
        return N;
    }

    // 获得第 i 个元素，头结点不算，从1开始计数
    public T get(int i){
        Node n = head;
        // 循环 i 次
        for (int index = 0; index < i; index++) {
            n = n.next;
        }
        return n.val;
    }

    public void insert(T t){
        Node n = head;
        while (n.next!= null){
            n = n.next;
        }
        Node newNode = new Node(t, null);
        n.next = newNode;
        N++;
    }

    public void  insert(int i , T t){
        // 找到 i 位置前一个节点
        Node pre = head;
        // 循环 i - 1 次到达 i - 1 位置
        for (int index = 0; index < i - 1; index++) {
            pre = pre.next;
        }
        // 找到 i 位置的节点
        Node cur = pre.next;
        Node newNode = new Node(t, cur);
        pre.next = newNode;
        N++;
    }

    // 删除 i 处的元素并返回
    public T remove(int i ){
        Node pre = head;
        // 循环 i - 1 次到达 i - 1 位置
        for (int index = 0; index < i - 1; index++) {
            pre = pre.next;
        }
        Node cur = pre.next;
        pre.next = cur.next.next;
        N--;
        return cur.val;
    }

    // 返回第一次出现的位置
    public int indexOf(T t){
        Node n = head;
        for (int i = 1; n.next != null; i++){
            n = n.next;
            if (n.val.equals(t)){
                return i;
            }
        }
        return -1;
    }
}
