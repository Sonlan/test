package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/7.
 * 链表中倒数第K个节点
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 解题思路：维护两个指针，位置距离相差为K，每次向前走一步，当前面的指针到底了，后面的即为倒数第k个节点
 */
public class Solution14 {
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode top = head;
        int i=0,j=0;
        while (null != head){
            j++;
            if(j-i>k){
                i++;
                top = top.next;
            }
            head = head.next;
        }
        if(j-i!=k) return null;
        return top;
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(8);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        Solution14 solution14 = new Solution14();
        System.out.println(solution14.FindKthToTail(node1,5).val);

    }
}
