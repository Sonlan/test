package song.tooffer;

/**
 * Created by Administrator on 2017/3/7.
 * 排序链表合并
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 解题思路：先确定一个链表，另外一个直接往里插值，注意记录上一个节点以及当前节点就行,另外注意pre节点的初始值。
 */
public class Solution16 {
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode res = new ListNode(0);
        res.next = list1;
        ListNode pre = res;
        while (null != list2){
            int val = list2.val;
            while (null != list1){
                if(val <= list1.val){
                    ListNode node = new ListNode(val);
                    node.next = list1;
                    pre.next = node;
                    break;
                }else{
                    pre = list1;
                    list1 = list1.next;
                }
            }
            if(null == list1){
                pre.next = new ListNode(val);
            }
            list2 = list2.next;
        }
        return res.next;
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(5);
        ListNode node4 = new ListNode(7);

        ListNode node5 = new ListNode(1);
        ListNode node6 = new ListNode(3);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(7);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node5.next = node6;
        node6.next = node7;
        node7.next = node8;

        Solution16 solution16 = new Solution16();
        ListNode reverse = solution16.Merge(node1,node5);
        System.out.println(reverse);
    }
}
