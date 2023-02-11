package 链表;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/03/09/18:30
 * @Description:
 */
class Node {
    int val;
    Node next;

    Node(int x) {
        val = x;
    }
}

public class SingleLinkedList {
    private Node head = new Node(0);
    public static void main(String[] args) {

    }

    public void add(Node node){
        Node temp = head;
        while (true){
            if (temp.next == null){
                break;
            }
            temp = temp.next;
        }
        temp.next = node;
    }


}
