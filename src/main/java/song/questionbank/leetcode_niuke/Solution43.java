package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 Note:
 You may assume that duplicates do not exist in the tree.
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
//中序，后序重建二叉树。先找根，后序先扫到中序中的谁，谁就是跟节点。
public class Solution43 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) return null;
        return buildTreeCore(inorder,0,inorder.length,postorder,postorder.length);
    }

    private TreeNode buildTreeCore(int [] inorder,int s1,int e1,int [] postorder, int e2){
        if(s1>=e1 || e2<0) return null;
        for(int i=e2-1;i>=0;i--){
            for(int j=s1;j<e1;j++){
                if(inorder[j] == postorder[i]){
                    TreeNode root = new TreeNode(inorder[j]);
                    root.left = buildTreeCore(inorder, s1, j, postorder, e2-1);
                    root.right = buildTreeCore(inorder, j+1, e1, postorder, e2-1);
                    return root;
                }
            }
        }
        return null;
    }
}
