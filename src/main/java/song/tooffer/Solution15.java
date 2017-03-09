package song.tooffer;

/**
 * Created by Administrator on 2017/3/7.
 * 反转链表
 * 输入一个链表，反转链表后，输出链表的所有元素
 */
public class Solution15 {
    public ListNode ReverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode hea=new ListNode(0);
        hea.next=head;
        ListNode p1,p2;
        p1=head;
        p2=head.next;
        while(p1.next!=null){
            p1.next=p2.next;
            p2.next=hea.next;
            hea.next=p2;
            p2=p1.next;
        }
        return hea.next;

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

        Solution15 solution15 = new Solution15();
        ListNode reverse = solution15.ReverseList(node1);
        System.out.println(reverse);
    }

}
