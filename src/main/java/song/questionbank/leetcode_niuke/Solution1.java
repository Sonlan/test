package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/22.
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node
 */



class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
}

public class Solution1 {
    /*public int run(TreeNode root) {
        if(null == root) return 0;
        int left = 1+run(root.left);
        int right = 1+run(root.right);
        return left<right?left:right;
    }*/
    public int run(TreeNode root) {
        if(root==null)
            return 0;
        if(root.left==null&&root.right==null)
            return 1;
        if(root.left==null)
            return run(root.right)+1;
        if(root.right==null)
            return run(root.left)+1;
        return Math.min(run(root.left),run(root.right))+1;
    }

    public static void main(String [] args){
        Solution1 sol = new Solution1();
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        System.out.println(sol.run(node1));
    }
}
