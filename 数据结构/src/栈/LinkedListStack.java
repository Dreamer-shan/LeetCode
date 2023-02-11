package 栈;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/03/08/11:05
 * @Description:
 */
class Node{
    public Node prev;
    private Object data;
    public Node next;

    public Node(Node prev, Object data, Node next) {
        this.prev = prev;
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }
}
public class LinkedListStack {
    private int size;
    private Node tail;

    public LinkedListStack(int size, Node tail) {
        this.tail = null;
    }

    public boolean push(Object data){
        Node node = new Node(tail, data, null);
        if (size > 0){
            tail.next = node;
        }
        tail = node;
        size++;
        return true;
    }
    public Object pop(){
        if (size <= 0){
            return null;
        }
        Object data = tail.getData();
        tail = tail.prev;
        if (tail != null){
            tail.next =null;
        }
        size--;
        return data;
    }
}
