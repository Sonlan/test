package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/23.
 *
 Given a binary tree, return the postorder traversal of its nodes' values.
 For example:
 Given binary tree{1,#,2,3},
 1
 \
 2
 /
 3

 return[3,2,1].
 Note: Recursive solution is trivial, could you do it iteratively?
 */

import java.util.ArrayList;
public class Solution6 {
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        postorderTraversalCore(root,list);
        return list;
    }

    private void postorderTraversalCore(TreeNode root,ArrayList<Integer> list){
        if(null == root) return;
        if(null != root.left) postorderTraversalCore(root.left, list);
        if(null != root.right) postorderTraversalCore(root.right, list);
        list.add(root.val);
        return;
    }
}
