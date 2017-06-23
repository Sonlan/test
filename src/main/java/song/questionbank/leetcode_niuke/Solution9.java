package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/23.
 * Given a linked list, return the node where the cycle begins. If there is no cycle, returnnull.
 Follow up:
 Can you solve it without using extra space?
 */
public class Solution9 {
    public ListNode detectCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode lowNode = head;
        while (null != fastNode && null != fastNode.next){
            fastNode = fastNode.next.next;
            lowNode = lowNode.next;
            if(fastNode == lowNode)
                break;
        }
        if(null == fastNode || null == fastNode.next) return null;
        fastNode = head;
        while (fastNode != lowNode){
            fastNode = fastNode.next;
            lowNode = lowNode.next;
        }
        return fastNode;
    }

    public static void main(String [] args){
        Solution9 sol = new Solution9();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;
        ListNode result = sol.detectCycle(node1);
        System.out.println(result);
    }
}
