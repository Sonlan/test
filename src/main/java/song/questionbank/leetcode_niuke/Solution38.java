package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path
 * such that adding up all the values along the path equals the given sum.
 For example:
 Given the below binary tree andsum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \      \
 7    2      1
 return true, as there exist a root-to-leaf path5->4->11->2which sum is 22.
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
public class Solution38 {
    public boolean hasPathSum(TreeNode root, int sum) {
        if(null == root) return false;
        return hasPathSumCore(root,sum,0);
    }
    private boolean hasPathSumCore(TreeNode root,int sum,int curSum){
        if(null == root.left && null == root.right) {
            if(curSum+root.val == sum){
                return true;
            }
            return false;
        }
        if(null != root.left) {
            if(hasPathSumCore(root.left, sum, curSum + root.val)) return true;
        }
        if(null != root.right) {
            if(hasPathSumCore(root.right, sum, curSum + root.val)) return true;
        }
        return false;
    }
}
