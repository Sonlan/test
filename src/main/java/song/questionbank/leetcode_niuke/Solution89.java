package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/23.
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 For example:
 Given1->2->3->4->5->NULL and k =2,
 return4->5->1->2->3->NULL.
 */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
//n超过链表长度则n对链表长度取余
public class Solution89 {
    public ListNode rotateRight(ListNode head, int n) {
        if(n<=0) return head;
        ListNode pHead;
        ListNode pre = head;
        ListNode fast = head,slow = head;
        int len=0;
        while (null != slow){
            len++;
            slow = slow.next;
        }
        if(0 == len ) return head;
        slow = head;
        n = n%len;

        while (null != fast && n-->=0){
            pre = fast;
            fast = fast.next;
        }
        if(n>-1) return head;

        while (null != fast){
            slow = slow.next;
            pre = fast;
            fast = fast.next;
        }
        pre.next = head;
        pHead = slow.next;
        slow.next = null;
        return pHead;
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
       /* ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;*/
        Solution89 sol = new Solution89();
        ListNode node = sol.rotateRight(node1,3);
        System.out.println(node);
    }
}
