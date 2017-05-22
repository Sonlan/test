package song.questionbank.tooffer;

import java.util.*;

/**
 * Created by Song on 2017/3/9.
 * 从上往下打印二叉树
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 解题思路：借助队列，取出值，并将该节点的左右子树依次放入队列。
 */
public class Solution22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<Integer>();
        while (null !=root){
            list.add(root.val);
            if(null != root.left) queue.add(root.left);
            if(null != root.right) queue.add(root.right);
            root = queue.poll();
        }
        return list;
    }
}