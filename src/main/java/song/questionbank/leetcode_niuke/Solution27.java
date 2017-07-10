package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/10.
 * Given a binary tree, find the maximum path sum.
 The path may start and end at any node in the tree.
 For example:
 Given the below binary tree,
 1
 / \
 2   3

 Return6.
 */

import sun.reflect.generics.tree.Tree;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution27 {
    private int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPathCore(root);
        return max;
    }

    public int maxPathCore(TreeNode root){
        if(null == root) return 0;
        int left = maxPathCore(root.left);
        left = left<0?0:left;
        int right = maxPathCore(root.right);
        right = right<0?0:right;
        max=max>(left+right+root.val)?max:(left+right+root.val);
        return root.val+(left>right?left:right);
    }

    public static void main(String [] args){
        TreeNode node1 = new TreeNode(-2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node1.right = node2;node1.left = node3;
        Solution27 sol = new Solution27();
        System.out.println(sol.maxPathSum(node1));
    }
}
