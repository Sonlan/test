package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).
 For example:
 Given binary tree{3,9,20,#,#,15,7},
 3
 / \
 9  20
 /  \
 15   7

 return its zigzag level order traversal as:
 [
 [3],
 [20,9],
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
public class Solution46 {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null == root) return result;
        int layer = 0,len;
        TreeNode curNode;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        while (!queue.isEmpty()){
            len = queue.size();
            ArrayList<Integer> curRow = new ArrayList<Integer>();
            while ((--len)>=0){
                curNode = queue.poll();
                if(layer%2!=0){
                    curRow.add(curNode.val);
                }else {
                    curRow.add(0,curNode.val);
                }
                if(null != curNode.left) queue.add(curNode.left);
                if(null != curNode.right) queue.add(curNode.right);
            }
            result.add(curRow);
            layer++;
        }
        return result;
    }

    public static void main(String [] args){
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(0);
        test.add(0,1);
        System.out.println(test);
    }
}
