package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/8.
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 For example,
 Given n = 3, your program should return all 5 unique BST's shown below.
 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3

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
 *     TreeNode(int x) { val = x; left = null; right = null; }
 * }
 */
//值得一看，深入理解递归，定义递归核心函数的功能，用即可
public class Solution53 {
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTreesCore(1,n);
    }
    //递归核心，创建所有以[low,high]的二叉搜索树，每个元素为BST的根节点
    public ArrayList<TreeNode> generateTreesCore(int low,int high){
        ArrayList<TreeNode> result = new ArrayList<TreeNode>();
        if(low>high){
            result.add(null);return result;
        }
        if(low == high) {
            result.add(new TreeNode(low));return result;
        }
        for(int i=low;i<=high;i++){
            ArrayList<TreeNode> left = generateTreesCore(low,i-1);
            ArrayList<TreeNode> right = generateTreesCore(i+1,high);
            for(int j=0;j<left.size();j++){
                for(int k=0;k<right.size();k++){
                    TreeNode node = new TreeNode(i);
                    node.left = left.get(j);
                    node.right = right.get(k);
                    result.add(node);
                }
            }
        }
        return result;
    }
}
