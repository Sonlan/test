package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 For example:
 Given the below binary tree and sum = 22,
 5
 / \
 4   8
 /   / \
 11  13  4
 /  \    / \
 7    2  5   1
 return
 [
 [5,4,11,2],
 [5,8,4,5]
 ]
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
public class Solution37 {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null == root) return result;
        pathSumCore(root,sum,result,new ArrayList<Integer>(),0);
        return result;
    }

    private void pathSumCore(TreeNode root,int sum,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> curList,int curSum){
        curList.add(root.val);
        if(null == root.left && null == root.right) {
            if(curSum+root.val == sum){
                result.add(new ArrayList<Integer>(curList));
            }
            curList.remove(curList.size()-1);
            return;
        }
        if(null != root.left)
            pathSumCore(root.left,sum,result,curList,curSum+root.val);
        if(null != root.right)
            pathSumCore(root.right, sum, result, curList, curSum+root.val);
        curList.remove(curList.size()-1);
        return;
    }
}
