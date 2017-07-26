package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/26.
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 Assume a BST is defined as follows:
 The left subtree of a node contains only nodes with keys less than the node's key.
 The right subtree of a node contains only nodes with keys greater than the node's key.
 Both the left and right subtrees must also be binary search trees.

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

import java.util.Stack;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//看看三种遍历方式的非递归实现方式
public class Solution51 {
    //错误
    /*public boolean isValidBST(TreeNode root) {
        if(null == root) return true;
        if(null != root.left && root.val<root.left.val) return false;
        if(null != root.right && root.val>root.right.val) return false;
        return isValidBST(root.left)&&isValidBST(root.right);
    }*/
    //中序
    public boolean isValidBST(TreeNode root) {
        if(null == root) return true;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode pre = null,cur = null;

        while (null != root || !stack.isEmpty()) {
            while (null != root){
                stack.push(root);
                root = root.left;
            }
            if(!stack.isEmpty()) {
                cur = stack.pop();
                if (null != pre && pre.val >= cur.val) return false;
                pre = cur;
                root = cur.right;
            }
        }
        return true;
    }


}
