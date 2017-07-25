package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given a binary tree, determine if it is height-balanced.
 For this problem, a height-balanced binary tree is defined as a binary tree
 in which the depth of the two subtrees of every node never differ by more than 1.
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
public class Solution39 {
    public boolean isBalanced(TreeNode root) {
        if(null == root) return true;
        int left = sumDepth(root.left,1);
        int right = sumDepth(root.right,1);
        if(Math.abs(left-right)<=1) return isBalanced(root.left)&&isBalanced(root.right);
        return false;
    }

    private int sumDepth(TreeNode root,int height){
        if(null == root) return height-1;
        return sumDepth(root.left,height+1)>sumDepth(root.right,height+1)?sumDepth(root.left,height+1):sumDepth(root.right,height+1);
    }

    public static void main(String [] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        node1.left = node2;
        System.out.println(new Solution39().isBalanced(node1));
    }
}
