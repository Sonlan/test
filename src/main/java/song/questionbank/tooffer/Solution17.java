package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/7.
 * 树的子结构
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 解题思路：递归，（1）判断当前节点值是否相同，相同则同样去判定二者左右子树。
 *              （2）若当前值不同，则递归找左右子树有没有跟第一个元素匹配的值
 *              （3）注意，子树中为空 和 初始的树为空， 意义不一样
 */
public class Solution17 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(null == root2 || null == root1) return false;
        if(root1.val == root2.val){
            boolean flag = isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
            if(flag) return true;
        }
        return HasSubtree(root1.left,root2)||HasSubtree(root1.right,root2);
    }

    private boolean isSubtree(TreeNode root1,TreeNode root2){
        if(null == root1 && null != root2) return false;
        if(null == root2) return true;
        if(root1.val == root2.val){
            return isSubtree(root1.left,root2.left)&&isSubtree(root1.right,root2.right);
        }else return false;
    }

    public static void main(String [] args){
        System.out.println(true||false);
    }
}