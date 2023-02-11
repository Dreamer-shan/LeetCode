package vivo;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: shy
 * @Date: 2021/06/17/20:09
 * @Description:
 */


import java.util.Scanner;

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

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5};
        ListNode root = create(arr);
        List<Integer> list = help(root);
        System.out.println(list);
        ListNode reverse = reverse(root, 2, 3);
        List<Integer> list1 = help(reverse);
        System.out.println(list1);

    }

    public static ListNode create(int[] arr) {
        if (arr.length == 0 || arr == null) return null;
        ListNode root = new ListNode(arr[0]);
        ListNode dum = new ListNode(0, root);
        for (int i = 1; i < arr.length; i++) {
            root.next = new ListNode(arr[i]);
            root = root.next;
        }
        return dum.next;
    }

    public static List<Integer> help(ListNode root) {
        ListNode temp = root;
        List<Integer> list = new ArrayList<>();
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        return list;
    }

    public static ListNode reverse(ListNode root, int left, int right){
        if (root == null || root.next == null)  return root;
        ListNode dum = new ListNode(0, root);
        ListNode prev = dum;
        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }
        ListNode cur = prev.next;
        for (int i = 0; i < right - left; i++) {
            ListNode nextNode = cur.next;
            cur.next = nextNode.next;
            nextNode.next = prev.next;
        }
        return dum.next;
    }
}



