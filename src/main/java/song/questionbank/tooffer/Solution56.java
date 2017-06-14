package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/14.
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
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
public class Solution56 {
    public ListNode deleteDuplication(ListNode pHead) {
        if(null == pHead || null == pHead.next) return pHead;

        ListNode p = new ListNode(0);
        p.next = pHead;
        ListNode q = p;
        ListNode temp;
        while (null !=p && null !=p.next && null != p.next.next){
            if(p.next.val == p.next.next.val){
                temp = p.next.next;
                while (null != temp){
                    if(null != temp.next) {
                        if (temp.next.val != temp.val) {
                            temp = temp.next;
                            break;
                        }
                    }
                    temp = temp.next;
                }
                p.next = temp;
            }else {
                p = p.next;
            }
        }
        return q.next;
    }

    public static void main(String [] args){
        ListNode p1 = new ListNode(1);
        ListNode p2 = new ListNode(1);
        ListNode p3 = new ListNode(2);
        ListNode p4 = new ListNode(3);
        ListNode p5 = new ListNode(3);
        ListNode p6 = new ListNode(3);
        p1.next = p2; p2.next = p3; p3.next = p4; p4.next = p5; p5.next = p6;
        ListNode p = new Solution56().deleteDuplication(p1);
        System.out.println();
    }
}
