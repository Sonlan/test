package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/3.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 */
/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
import java.util.*;

public class Solution3 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        printListNode(listNode,result);
        return result;
    }

    private void printListNode(ListNode listNode,ArrayList<Integer> list){
        if(null != listNode && null != listNode.next) printListNode(listNode.next,list);
        if(null != listNode) list.add(listNode.val);
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;

        Solution3 solution3 = new Solution3();
        ArrayList<Integer> list = new ArrayList<Integer>();
        list = solution3.printListFromTailToHead(null);

        for(int val:list){
            System.out.println(val);
        }
    }
}


class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

