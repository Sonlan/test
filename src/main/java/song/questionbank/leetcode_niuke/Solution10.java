package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/23.
 * Given a linked list, determine if it has a cycle in it.
 Follow up:
 Can you solve it without using extra space?
 */
public class Solution10 {
    public boolean hasCycle(ListNode head) {
        ListNode fastNode = head;
        ListNode lowNode = head;
        while (null != fastNode && null != fastNode.next){
            fastNode = fastNode.next.next;
            lowNode = lowNode.next;
            if(fastNode == lowNode)
                break;
        }
        if(null == fastNode || null == fastNode.next) return false;
        return true;
    }
}
