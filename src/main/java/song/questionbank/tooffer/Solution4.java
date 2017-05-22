package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/3.
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回
 *
 * 解题基本思想：
 * （1）根据先序遍历，确定根节点为1，再从中序遍历中得知，1左边的472为其左子树，右边的5386为右子树
 * （2）按（1）迭代
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
public class Solution4 {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        return reGenerateBTree(pre,in,0,pre.length-1,0,in.length-1);
    }

    private TreeNode reGenerateBTree(int [] pre, int [] in,int m,int n,int p,int q){
        TreeNode root = null;
        if(n<pre.length && q<in.length && m<pre.length && p<in.length && m<=n&& p<=q) {
            root = new TreeNode(pre[m]);
            if (m < n && p < q) {
                int i = p;//i代表左子树中含i-p个元素
                while (in[i] != pre[m] && i >= p && i <= q) {
                    i++;
                }
                //区间是关键
                root.left = reGenerateBTree(pre, in, m + 1, m+i-p, p, i - 1);
                root.right = reGenerateBTree(pre, in, m+i-p+1, n, i + 1, q);
            }
        }
        return root;
    }

    public static void main(String [] args){
        Solution4 solution4 = new Solution4();
        int [] pre = {1,2,4,3,5,6};
        int [] in = {4,2,1,5,3,6};
        TreeNode root = solution4.reConstructBinaryTree(pre,in);
        System.out.println(root);
    }
}

   class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
