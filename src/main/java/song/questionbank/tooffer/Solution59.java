package song.questionbank.tooffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Song on 2017/6/18.
 * 请实现一个函数按照之字形打印二叉树，
 * 即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 思路：两栈来回，待看其他人思路
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
public class Solution59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if(null == pRoot) return result;
        int floor = 0;
        Stack<TreeNode> curStack = new Stack<TreeNode>();
        Stack<TreeNode> nextStack = new Stack<TreeNode>();
        curStack.push(pRoot);
        while (!curStack.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<Integer>();
            while (!curStack.isEmpty()) {
                TreeNode curNode = curStack.pop();
                temp.add(curNode.val);
                if (floor % 2 == 0) {
                    if (null != curNode.left) nextStack.push(curNode.left);
                    if (null != curNode.right) nextStack.push(curNode.right);
                }else{
                    if (null != curNode.right) nextStack.push(curNode.right);
                    if (null != curNode.left) nextStack.push(curNode.left);
                }
            }
            result.add(temp);
            floor++;
            curStack = nextStack;
            nextStack = new Stack<TreeNode>();
        }
        return result;
    }
}
