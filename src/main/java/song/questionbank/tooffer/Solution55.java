package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/14.
 * 一个链表中包含环，请找出该链表的环的入口结点
 *
 * 思路：第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
 第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=kn+x; n=x;
 可以看出p1实际走了k个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。
 */
/*
 public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}
*/
public class Solution55 {
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if(null == pHead || null == pHead.next) return null;
        ListNode fastNode = pHead;
        ListNode lowNode = pHead;

        while (null != fastNode && null != fastNode.next){
            fastNode = fastNode.next.next;
            lowNode = lowNode.next;
            if(fastNode == lowNode){
                fastNode = pHead;
                while (fastNode != lowNode){
                    fastNode = fastNode.next;
                    lowNode = lowNode.next;
                }
                if(fastNode == lowNode)
                    return fastNode;
            }
        }
        return null;
    }

    /*ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null || pHead.next == null)
            return null;
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        while(p2 != null && p2.next != null ){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2){
                p2 = pHead;
                while(p1 != p2){
                    p1 = p1.next;
                    p2 = p2.next;
                }
                if(p1 == p2)
                    return p1;
            }
        }
        return null;
    }*/
}
