package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/23.
 * Sort a linked list using insertion sort.
 */
public class Solution5 {
    public ListNode insertionSortList(ListNode head) {
        if(null == head || null == head.next) return head;
        ListNode root = new ListNode(0);
        root.next = new ListNode(head.val);
        head = head.next;
        ListNode p;
        ListNode pre = root;
        while (null != head ){
            pre = root;
            p = root.next;
            while (null != p && head.val>p.val ){
                pre = p;
                p = p.next;
            }
            pre.next = new ListNode(head.val);
            pre.next.next = p;
            head = head.next;
        }
        return root.next;
    }

    public static void main(String [] args){
        Solution5 sol = new Solution5();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node5;
        node5.next = node2;
        node2.next = node4;
        node4.next = node3;

        ListNode result = sol.insertionSortList(node1);
        System.out.println(result);
    }
}
