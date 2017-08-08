package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/8.
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 For example:
 Given1->2->3->4->5->NULL, m = 2 and n = 4,
 return1->4->3->2->5->NULL.
 Note:
 Given m, n satisfy the following condition:
 1 ≤ m ≤ n ≤ length of list.
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
public class Solution57 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(null == head || m == n) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode top1 = pHead,top2=null,pre = null,tmp;
        int count = 1;
        while (null != head){
            if(m == count){
                top2 = head;
                pre = head;
                head = head.next;
            }else if(m<count && n>count){
                tmp = head.next;
                head.next = pre;
                pre = head;
                head = tmp;
            }else if(n == count){
                top1.next=head;
                top2.next = head.next;
                head.next = pre;
                break;
            }else{
                top1 = head;
                head = head.next;
            }
            count++;
        }
        return pHead.next;
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);node1.next=node2;
        ListNode node3 = new ListNode(3);node2.next=node3;
        ListNode node4 = new ListNode(4);node3.next=node4;
        ListNode node5 = new ListNode(5);node4.next=node5;
        Solution57 sol = new Solution57();
        System.out.println(sol.reverseBetween(node1,2,4));
        System.out.println();
    }
}
