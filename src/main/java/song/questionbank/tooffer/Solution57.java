package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/14.
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class Solution57 {
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if(null == pNode) return null;
        if(null != pNode.right) {
            TreeLinkNode p = pNode.right;
            while (null != p.left) {
                p = p.left;
            }
            return p;
        }
        //可能再左子树或右子树
        while (null != pNode.next){
            if(pNode == pNode.next.left)  return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }
}
class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
