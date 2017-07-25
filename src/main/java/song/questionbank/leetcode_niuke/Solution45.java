package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given a binary tree, find its maximum depth.
 The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
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
public class Solution45 {
    public int maxDepth(TreeNode root) {
        if(null == root) return 0;
        return maxDepthCore(root,1);
    }

    private int maxDepthCore(TreeNode root,int curDepth){
        if(null == root) return curDepth-1;
        int left = maxDepthCore(root.left, 1+curDepth);
        int right = maxDepthCore(root.right, 1+curDepth);
        return left>right?left:right;
    }
}
