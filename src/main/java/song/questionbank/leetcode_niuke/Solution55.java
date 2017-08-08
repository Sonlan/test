package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/8.
 * Given a binary tree, return the inorder traversal of its nodes' values.
 For example:
 Given binary tree{1,#,2,3},
 1
 \
 2
 /
 3

 return[1,3,2].
 Note: Recursive solution is trivial, could you do it iteratively?
 confused what"{1,#,2,3}"means? > read more on how binary tree is serialized on OJ.

 OJ's Binary Tree Serialization:
 The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.
 Here's an example:
 1
 / \
 2   3
 /
 4
 \
 5
 The above binary tree is serialized as"{1,2,3,#,#,4,#,#,5}".
 */

import java.util.ArrayList;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution55 {
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        inorderTraversalCore(root,result);
        return result;
    }

    public void inorderTraversalCore(TreeNode root,ArrayList<Integer> list){
        if(null == root) return;
        inorderTraversalCore(root.left,list);
        list.add(root.val);
        inorderTraversalCore(root.right,list);
    }
}
