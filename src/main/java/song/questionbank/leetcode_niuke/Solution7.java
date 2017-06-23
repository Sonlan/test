package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/6/23.
 * Given a binary tree, return the preorder traversal of its nodes' values.
 For example:
 Given binary tree{1,#,2,3},
 1
 \
 2
 /
 3

 return[1,2,3].
 Note: Recursive solution is trivial, could you do it iteratively?
 */
public class Solution7 {
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        preorderTraversalCore(root,list);
        return list;
    }

    private void preorderTraversalCore(TreeNode root,ArrayList<Integer> list){
        if(null == root) return;
        list.add(root.val);
        preorderTraversalCore(root.left, list);
        preorderTraversalCore(root.right, list);
    }
}
