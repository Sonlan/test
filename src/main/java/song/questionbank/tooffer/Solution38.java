package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/12.
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 可以考虑一下非递归写法，层序遍历
 */
/**
 public class TreeNode {
 int val = 0;
 TreeNode left = null;
 TreeNode right = null;

 public TreeNode(int val) {
 this.val = val;

 }

 }
 */
public class Solution38 {
    public int TreeDepth(TreeNode root) {
        if(null == root) return 0;
        int left = 1+TreeDepth(root.left);
        int right = 1+TreeDepth(root.right);
        return left>right?left:right;
    }
}
