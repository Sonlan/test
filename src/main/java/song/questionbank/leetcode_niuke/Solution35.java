package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/24.
 * Given a binary tree
 struct TreeLinkNode {
 TreeLinkNode *left;
 TreeLinkNode *right;
 TreeLinkNode *next;
 }

 Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set toNULL.
 Initially, all next pointers are set toNULL.
 Note:
 You may only use constant extra space.
 You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).

 For example,
 Given the following perfect binary tree,
 1
 /  \
 2    3
 / \  / \
 4  5  6  7

 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \  / \
 4->5->6->7 -> NULL
 */

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

//同上一题
public class Solution35 {
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode cur;
        TreeLinkNode prev;
        TreeLinkNode dummy;
        while (null != root) {
            dummy = new TreeLinkNode(-1);
            prev = dummy;
            for (cur = root; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    prev.next = cur.left;
                    prev = prev.next;
                }
                if (cur.right != null) {
                    prev.next = cur.right;
                    prev = prev.next;
                }
            }
            root = dummy.next;
        }
    }
}
