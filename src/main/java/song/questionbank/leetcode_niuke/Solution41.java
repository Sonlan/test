package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/25.
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
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
//对比上一题，（1,2）中点取2，所以end取值为不达到的点
public class Solution41 {
    public TreeNode sortedArrayToBST(int[] num) {
        if(null == num || 0== num.length) return null;
        return sortedArrayToBSTCore(num,0,num.length);
    }

    private TreeNode sortedArrayToBSTCore(int [] num,int start,int end){
        if(start>=end) return null;
        int mid = (end-start)/2+start;
        TreeNode root = new TreeNode(num[mid]);
        if(mid != start)
            root.left = sortedArrayToBSTCore(num, start, mid);
        root.right = sortedArrayToBSTCore(num, mid+1, end);
        return root;
    }
}
