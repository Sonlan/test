package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/12.
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
 */
public class Solution39 {
    public boolean IsBalanced_Solution(TreeNode root) {
        if(null == root)
            return true;
        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);
        if(Math.abs(left-right)>1) return false;
        return true;
    }

    private int TreeDepth(TreeNode root) {
        if(null == root) return 0;
        int left = 1+TreeDepth(root.left);
        int right = 1+TreeDepth(root.right);
        return left>right?left:right;
    }
}
