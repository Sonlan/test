package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; next = null; }
 * }
 */
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//可以一看，注意每次折半之后，必须断掉前后联系，否则，递归永不停止
public class Solution40 {
    public TreeNode sortedListToBST(ListNode head) {
        if(null == head) return null;
        ListNode mid = findMiddle(head);
        if(null == mid) return null;
        TreeNode root = new TreeNode(mid.val);
        if(mid != head)
             root.left = sortedListToBST(head);
        root.right = sortedListToBST(mid.next);
        return root;
    }

    private ListNode findMiddle(ListNode head){
        if(null == head) return null;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode fastNode = head;
        ListNode slowNode = head;
        while (null != fastNode && null != fastNode.next){
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            pre = pre.next;
        }
        pre.next=null;//断开连接
        return slowNode;
    }
}
