package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/16.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 For example,
 Given1->1->2, return1->2.
 Given1->1->2->3->3, return1->2->3.
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
public class Solution67 {
    public static ListNode deleteDuplicates(ListNode head) {
        if(null == head || null == head.next) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode pre = pHead;
        while (null != head && null != head.next){
            while (head.val == head.next.val){
                head = head.next;
                if(null == head.next) break;
            }
            pre.next = head;
            pre = head;
            head = head.next;
        }
        return pHead.next;
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1); node1.next = node2;
/*        ListNode node3 = new ListNode(2);node2.next = node3;
        ListNode node4 = new ListNode(2); node3.next = node4;
        ListNode node5 = new ListNode(3);node4.next = node5;*/
        ListNode node = deleteDuplicates(node1);
        System.out.println(node);
    }
}
