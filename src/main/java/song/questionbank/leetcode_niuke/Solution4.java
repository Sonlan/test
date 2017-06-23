package song.questionbank.leetcode_niuke;


/**
 * Created by Song on 2017/6/23.
 * Sort a linked list in O(n log n) time using constant space complexity.
 */
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
         val = x;
         next = null;
      }
  }

public class Solution4 {

    public ListNode sortList(ListNode head) {
        if(null == head || null == head.next) return head;
        //避免偶数情况，死循环
        if(null == head.next.next){
            if(head.val<head.next.val) return head;
            ListNode newHead = new ListNode(0);
            newHead.next = head.next;
            newHead.next.next = head;
            head.next = null;
            return newHead.next;
        }
        ListNode mid = findMiddle(head);
        ListNode right = sortList(mid.next);
        mid.next = null;
        ListNode left = sortList(head);
        return mergeList(left,right);
    }

    private ListNode findMiddle(ListNode head){
        ListNode fastNode = head;
        ListNode lowNode = head;
        while (null != fastNode && null != fastNode.next){
            fastNode = fastNode.next.next;
            lowNode = lowNode.next;
        }
        return lowNode;
    }

    private ListNode mergeList(ListNode head1,ListNode head2){
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (null != head1 && null != head2){
            if(head1.val<head2.val){
                p.next = new ListNode(head1.val);
                head1 = head1.next;
            }else{
                p.next = new ListNode(head2.val);
                head2 = head2.next;
            }
            p = p.next;
        }
        while (null != head1){
            p.next = new ListNode(head1.val);
            p = p.next;
            head1 = head1.next;
        }
        while (null != head2){
            p.next = new ListNode(head2.val);
            p = p.next;
            head2 = head2.next;
        }
        return head.next;
    }

    public static void main(String [] args){
        Solution4 sol = new Solution4();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node5;
        node5.next = node2;
        node2.next = node4;
        node4.next = node3;

        ListNode result = sol.sortList(node1);
        System.out.println(result);
    }
}
