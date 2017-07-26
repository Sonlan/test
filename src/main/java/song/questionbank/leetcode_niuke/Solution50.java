package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/26.
 * Two elements of a binary search tree (BST) are swapped by mistake.
 Recover the tree without changing its structure.
 Note:
 A solution using O(n ) space is pretty straight forward. Could you devise a constant space solution?

 confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

 OJ's Binary Tree Serialization:
 The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 Here's an example:
 1
 / \
 2   3
 /
 4
 \
 5
 The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//注释的超时了，思想都一样，中序遍历，前后两两比较，记录异常数据，差别在于列表操作更耗时吧
public class Solution50 {

    TreeNode pre=null;
    TreeNode node1=null;
    TreeNode node2=null;


    public void recoverTree(TreeNode root) {
        if(root==null)
            return;
        inverse(root);
        int tem=node1.val;
        node1.val=node2.val;
        node2.val=tem;


    }

    public void inverse(TreeNode root){
        if(root==null)return;

        inverse(root.left);
        if(pre!=null){
            if(pre.val>=root.val){
                if(node1==null){
                    node1=pre;
                }
                node2=root;
            }
        }
        pre=root;
        inverse(root.right);


    }

    public static void main(String [] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node3.left = node4;node3.right=node2;
        node4.left = node1;node2.right=node5;
        Solution50 sol = new Solution50();
        sol.recoverTree(node3);
    }
}
