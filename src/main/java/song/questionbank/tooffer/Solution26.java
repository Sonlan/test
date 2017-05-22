package song.questionbank.tooffer;

/**
 * Created by Song on 2017/3/24.
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
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
public class Solution26 {
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(null == pRootOfTree) return null;
        if(null == pRootOfTree.left && null == pRootOfTree.right) return pRootOfTree;
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode p = left;
        while (null != p&&null !=p.right){
            p=p.right;
        }
        if(null != p){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        TreeNode right = Convert(pRootOfTree.right);
        if(null != right){
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return null == left?pRootOfTree:left;
    }




    public static void main(String [] args){
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node5.left = node4;node5.right = node6;
        node4.left = node3;node3.left = node2;node2.left = node1;
        node6.right = node7;node7.right = node8;

        Solution26 solution26 = new Solution26();
        TreeNode root = solution26.Convert(node5);
        System.out.println(root);

    }

}
