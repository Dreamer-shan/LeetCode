//import java.util.*;
//
//class ListNode {
//    int val;
//    ListNode next;
//    ListNode() {
//    }
//    ListNode(int val) {
//        this.val = val;
//    }
//    ListNode(int val, ListNode next) {
//        this.val = val;
//        this.next = next;
//    }
//}
//
//class Solution {
//    /**
//     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
//     *
//     * @param S ListNode类 val表示权值，next指向下一个元素
//     * @return ListNode类
//     */
//    public static ListNode solve(ListNode S) {
//        // write code here
//        if (S == null || S.next == null) {
//            return S;
//        }
//        int count = 1;
//        ListNode cur = S;
//        while (cur.next != null) {
//            count++;
//            cur = cur.next;
//        }
//        int min = Integer.MAX_VALUE;
//        int mod = count;
//        cur.next = S;
//        while (mod > 0) {
//            cur = cur.next;
//            mod -= 1;
//        }
//        ListNode ans = cur.next;
//        if (ans.val < min) {
//            min = ans.val;
//        }
//        while (ans.next.val < min) {
//            ans = cur.next;
//            break;
//        }
//        ans.next = null;
//        return ans;
//    }
//
//    public static void main(String[] args) {
//        ListNode l1 = new ListNode();
//        l1.val = 1;
//        ListNode l2 = new ListNode();
//        l2.val = 2;
//        ListNode l3 = new ListNode();
//        l3.val = 3;
//        l1.next = l2;
//        l2.next = l3;
//        System.out.println(solve(l1));
//    }
//}
