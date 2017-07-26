package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/26.
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 For example, this binary tree is symmetric:
 1
 / \
 2   2
 / \ / \
 3  4 4  3

 But the following is not:
 1
 / \
 2   2
 \   \
 3    3

 Note:
 Bonus points if you could solve it both recursively and iteratively.
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
/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//可以看看，二叉树镜像判断，另外一种非递归解法，可以转化成数组，完全二叉树的数组表示方式
public class Solution48 {
    public boolean isSymmetric(TreeNode root) {
        if(null == root) return true;
        return isSymmetricCore(root.left,root.right);
    }

    private boolean isSymmetricCore(TreeNode node1,TreeNode node2){
        if(null == node1 && null == node2) return true;
        if(null == node1 || null == node2) return false;
        if(node1.val != node2.val) return false;
        return isSymmetricCore(node1.left,node2.right)&&isSymmetricCore(node1.right,node2.left);
    }
}
