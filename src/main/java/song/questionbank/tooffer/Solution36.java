package song.questionbank.tooffer;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Song on 2017/6/12.
 * 输入两个链表，找出它们的第一个公共结点
 * 网上思路：先统计两个链表的长度，长的先走差值，然后齐头并进，看是否有同一个节点
 */

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class Solution36 {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> nodeSet = new HashSet<ListNode>();
        while (null != pHead1){
            nodeSet.add(pHead1);
            pHead1 = pHead1.next;
        }
        while (null != pHead2){
            if(nodeSet.contains(pHead2))
                return pHead2;
            pHead2= pHead2.next;
        }
        return null;
    }
}
