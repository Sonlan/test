package song.questionbank.tooffer;

import java.util.ArrayList;
import java.util.LinkedList;


/**
 * Created by Song on 2017/6/18.
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
 */
/*
public class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }
}
*/
public class Solution60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null == pRoot) return result;
        LinkedList<TreeNode> curQueue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> nextQueue = new LinkedList<TreeNode>();
        curQueue.add(pRoot);

        while (!curQueue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while (!curQueue.isEmpty()) {
                TreeNode curNode = curQueue.getFirst();
                curQueue.removeFirst();

                temp.add(curNode.val);
                if(null != curNode.left) nextQueue.add(curNode.left);
                if(null != curNode.right) nextQueue.add(curNode.right);
            }
            result.add(temp);
            curQueue = nextQueue;
            nextQueue = new LinkedList<TreeNode>();
        }
        return result;
    }
}
