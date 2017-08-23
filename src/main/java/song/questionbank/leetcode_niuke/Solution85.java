package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/23.
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
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
public class Solution85 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode pHead = new ListNode(0);
        ListNode p = pHead;
        while (null != l1 && null !=l2){
            if(l1.val<=l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        while (null != l1){
            p.next = l1;
            l1 = l1.next;
            p = p.next;
        }
        while (null != l2){
            p.next = l2;
            l2 = l2.next;
            p = p.next;
        }
        return pHead.next;
    }
}
