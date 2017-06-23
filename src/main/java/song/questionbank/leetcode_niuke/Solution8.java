package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/23.
 * Given a singly linked list L: L 0→L 1→…→L n-1→L n,
 reorder it to: L 0→L n →L 1→L n-1→L 2→L n-2→…
 You must do this in-place without altering the nodes' values.
 For example,
 Given{1,2,3,4}, reorder it to{1,4,2,3}.

 */
public class Solution8 {
    public void reorderList(ListNode head) {
        if(null == head || null == head.next) return;
        ListNode mid = findMiddle(head);
        ListNode rightMirror = reverse(mid.next);
        mid.next = null;
        merge(head,rightMirror);
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

    private ListNode reverse(ListNode head){
        if(null == head || null == head.next) return head;
        ListNode p ;
        ListNode nextNode = head.next;
        head.next = null;
        while (null != nextNode){
            p = nextNode.next;
            nextNode.next = head;
            head = nextNode;
            nextNode = p;
        }
        return head;
    }

    private ListNode merge(ListNode node1,ListNode node2){
        ListNode root = new ListNode(0);
        ListNode p = root;
        while (null != node1 && null != node2){
            root.next = node1;
            node1 = node1.next;
            root.next.next = node2;
            node2 = node2.next;
            root = root.next.next;
        }
        if(null != node1) {
            root.next = node1;
            root = root.next;
        }
        if(null != node2){
            root.next = node2;
        }
        return p.next;
    }

    public static void main(String [] args){
        Solution8 sol = new Solution8();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        sol.reorderList(node1);
        System.out.println(node1);
    }
}
