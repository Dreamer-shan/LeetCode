package 建表;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/04/9:52
 * @Description:
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class Soluiton {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        ListNode root = build(arr);
        System.out.println(getLen(root));
        List<Integer> list = traverse(root);
        System.out.println(list);
        ListNode head = remove(root, 2);
        List<Integer> list1 = traverse(head);
        System.out.println(list1);

    }
    public static ListNode build(int[] arr){
        if (arr.length == 0)    return null;
        ListNode root = new ListNode(arr[0]);
        ListNode dum = new ListNode(0, root);
        for (int i = 1; i < arr.length; i++) {
            root.next = new ListNode(arr[i]);
            root = root.next;
        }
        return dum.next;
    }
    public static int getLen(ListNode root){
        int len  = 0;
        while (root != null){
            len++;
            root = root.next;
        }
        return len;
    }
    public static List<Integer> traverse(ListNode root){
        List<Integer> res = new ArrayList<>();
        if (root == null)   return res;
        while (root != null){
            res.add(root.val);
            root = root.next;
        }
        return res;
    }

    public static ListNode remove(ListNode head, int n){
        ListNode dum = new ListNode(0, head);
        ListNode slow = new ListNode(0, head);
        for (int i = 0; i < n - 1; i++) {
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dum.next;
    }

}
