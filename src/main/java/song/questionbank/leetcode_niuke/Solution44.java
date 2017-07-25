package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given preorder and inorder traversal of a tree, construct the binary tree.
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
//前序中序，重建二叉树，与上一题同一个思路，只不过前序从前往后扫
public class Solution44 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length != preorder.length) return null;
        return buildTreeCore(inorder,0,inorder.length,preorder,0);
    }

    private TreeNode buildTreeCore(int [] inorder,int s1,int e1,int [] preorder, int s2){
        if(s1>=e1 || s2>=preorder.length) return null;
        for(int i=s2;i<preorder.length;i++){
            for(int j=s1;j<e1;j++){
                if(inorder[j] == preorder[i]){
                    TreeNode root = new TreeNode(inorder[j]);
                    root.left = buildTreeCore(inorder, s1, j, preorder, s2+1);
                    root.right = buildTreeCore(inorder, j+1, e1, preorder, s2+1);
                    return root;
                }
            }
        }
        return null;
    }
}
