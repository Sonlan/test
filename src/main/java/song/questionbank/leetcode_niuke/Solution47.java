package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/26.
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 For example:
 Given binary tree{3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7

 return its level order traversal as:
 [
 [3],
 [9,20],
 [15,7]
 ]

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
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution47 {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null == root) return result;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int len;
        TreeNode curNode;
        while (!queue.isEmpty()){
            len = queue.size();
            ArrayList<Integer> curRow = new ArrayList<Integer>();
            while ((--len)>=0){
                curNode = queue.poll();
                curRow.add(curNode.val);
                if(null != curNode.left) queue.add(curNode.left);
                if(null != curNode.right) queue.add(curNode.right);
            }
            result.add(curRow);
        }
        return result;
    }
}
