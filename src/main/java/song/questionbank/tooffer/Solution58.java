package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/17.
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;

    }

}
*/
public class Solution58 {
    public boolean isSymmetrical(TreeNode pRoot) {
        if(null == pRoot) return true;
        return compareNode(pRoot.left,pRoot.right);
    }

    private boolean compareNode(TreeNode node1,TreeNode node2){
        if(null == node1) return null == node2;
        if(null == node2) return false;
        if(node1.val != node2.val) return false;
        return compareNode(node1.left,node2.right) && compareNode(node1.right,node2.left);
    }
}
