package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/18.
 * 给定一颗二叉搜索树，请找出其中的第k大的结点。例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 根据结果来看，应该是第k小的节点
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
public class Solution62 {
    TreeNode KthNode(TreeNode pRoot, int k) {
        TreeNode [] result = new TreeNode[1];
        kthNodeCore(pRoot,k,result);
        return result[0];
    }

    int i=0;
    void kthNodeCore(TreeNode root,int k,TreeNode [] result){
        if(null == root || null != result[0]) return;
        kthNodeCore(root.left,k,result);
        i++;
        if(i==k) result[0] = root;
        else kthNodeCore(root.right,k,result);
    }

}
