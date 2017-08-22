package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/9.
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 You should preserve the original relative order of the nodes in each of the two partitions.
 For example,
 Given1->4->3->2->5->2and x = 3,
 return1->2->2->4->3->5.
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
//碰到几次了，可以了解一下思路
public class Solution63 {
    //大的数上浮，碰到大的数，则抱团上浮
    public ListNode partition(ListNode head, int x) {
        if(null == head) return head;
        if(null == head.next) return head;
        ListNode pHead = new ListNode(0);
        pHead.next = head;
        ListNode p = new ListNode(0);
        ListNode q =p,tmp,pre=pHead;
        while (null != head){
            if(head.val>=x){
                p.next = head;
                p=p.next;
                head = head.next;
            }else if(null != q.next){
                if(null != pre){
                    pre.next = head;
                }
                pre = head;
                tmp = head.next;
                head.next = q.next;
                head = tmp;
            }else {
                pre = head;
                head = head.next;
            }
        }
        p.next=null;
        return pHead.next;
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);node1.next=node2;
        ListNode node3 = new ListNode(2);node2.next=node3;
        ListNode node4 = new ListNode(3);node3.next=node4;
        ListNode node5 = new ListNode(5);node4.next=node5;
        ListNode node6 = new ListNode(2);node5.next=node6;
        Solution63 sol = new Solution63();
        ListNode node = sol.partition(node1,3);
        System.out.println();
    }
}
