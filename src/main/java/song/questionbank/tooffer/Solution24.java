package song.questionbank.tooffer;

import java.util.ArrayList;

/**
 * Created by Song on 2017/3/10.
 * 二叉树中和为某一值的路径
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
 * 解题思路：对单个节点而已，累加其值，并对其左右叶子节点做同样的操作，若自己为叶子节点，则判断累加和是否相等。
 * 注意事项：因为是路径，跟之前的结果是相关的，所以先前的节点路径以及累加和都要传递到子节点，这个地方得注意ArrayList是引用传递，int基本类型是值传递，所以前者必须得重新建一个对象，而不是沿用同一个。
 */
public class Solution24 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> path = new ArrayList<Integer>();
        sum(root,paths,path,target,0);
        return paths;
    }

    private void sum(TreeNode root, ArrayList<ArrayList<Integer>> paths,ArrayList<Integer> path,int target,int sum) {
        if(null == root) return;
        path.add(root.val);
        sum += root.val;
        //叶子几点判断
        if(null == root.left && null == root.right){
            if(sum == target){
                paths.add(path);
            }
        }else {
            sum(root.left, paths, new ArrayList<Integer>(path), target, sum);
            sum(root.right, paths, new ArrayList<Integer>(path), target, sum);
        }
    }

    public static void main(String [] args){
        Solution24 solution24 = new Solution24();
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(12);
        TreeNode node4 = new TreeNode(7);
/*        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(1);
        TreeNode node7 = new TreeNode(2);*/

        node1.left = node2;node1.right=node3;
        node2.left=node4; //node2.right = node5;
        //node3.left = node6; node3.right = node7;

        ArrayList<ArrayList<Integer>> paths = solution24.FindPath(node1,22);
        System.out.println(paths);
    }
}
