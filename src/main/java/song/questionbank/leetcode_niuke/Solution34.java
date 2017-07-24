package song.questionbank.leetcode_niuke;


import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Song on 2017/7/24.
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 What if the given tree could be any binary tree? Would your previous solution still work?
 Note:
 You may only use constant extra space.

 For example,
 Given the following binary tree,
 1
 /  \
 2    3
 / \    \
 4   5    7

 After calling your function, the tree should look like:
 1 -> NULL
 /  \
 2 -> 3 -> NULL
 / \    \
 4-> 5 -> 7 -> NULL
 */
//值得一看
 class TreeLinkNode {
      int val;
      TreeLinkNode left, right, next;
      TreeLinkNode(int x) { val = x; }
  }

public class Solution34 {
/*    public void connect(TreeLinkNode root) {
        if(null == root) return;
        Queue<TreeLinkNode> curLayer = new LinkedBlockingQueue<TreeLinkNode>();
        Queue<TreeLinkNode> nextLayer = new LinkedBlockingQueue<TreeLinkNode>();
        curLayer.add(root);
        TreeLinkNode curNode;
        while (!curLayer.isEmpty()){
            while (!curLayer.isEmpty()) {
                curNode = curLayer.poll();
                curNode.next = curLayer.peek();
                if (null != curNode.left) nextLayer.add(curNode.left);
                if (null != curNode.right) nextLayer.add(curNode.right);
            }
            curLayer = nextLayer;
            nextLayer = new LinkedBlockingQueue<TreeLinkNode>();
        }
    }*/

/*    public void connect(TreeLinkNode root) {
        if(null == root) return;
        Queue<TreeLinkNode> curLayer = new LinkedBlockingQueue<TreeLinkNode>();
        curLayer.add(root);
        TreeLinkNode curNode;
        int len;
        while (!curLayer.isEmpty()){
            len = curLayer.size();
            while ((--len)>=0) {
                curNode = curLayer.poll();
                if(0 == len) curNode.next = null;
                else curNode.next = curLayer.peek();
                if (null != curNode.left) curLayer.add(curNode.left);
                if (null != curNode.right) curLayer.add(curNode.right);
            }
        }
    }*/
/*    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode cur;
        while (null != root) {
            TreeLinkNode dummy = new TreeLinkNode(-1);
            TreeLinkNode prev = dummy;
            for (cur = root; cur != null; cur = cur.next) {
                if (cur.left != null) {
                    prev.next = cur.left;
                    prev = prev.next;
                }
                if (cur.right != null) {
                    prev.next = cur.right;
                    prev = prev.next;
                }
            }
            root = dummy.next;
        }
    }*/
    //注释的均超时了
    public void connect(TreeLinkNode root) {
        if(root == null)
            return;
        TreeLinkNode dummy = new TreeLinkNode(-1);
        TreeLinkNode cur;
        TreeLinkNode prev = dummy;
        for(cur=root; cur !=null; cur = cur.next){
            if(cur.left !=null)
            {
                prev.next = cur.left;
                prev = prev.next;
            }
            if(cur.right !=null){
                prev.next = cur.right;
                prev = prev.next;
            }
        }
        connect(dummy.next);
    }

    public static void main(String [] args){
        TreeLinkNode node1 = new TreeLinkNode(1);
        TreeLinkNode node2 = new TreeLinkNode(2);
        TreeLinkNode node3 = new TreeLinkNode(3);
        TreeLinkNode node4 = new TreeLinkNode(4);
        TreeLinkNode node5 = new TreeLinkNode(5);
        node1.left = node2;node1.right = node3;
        node2.left = node4;node3.right = node5;
        new Solution34().connect(node1);
        System.out.println();
    }
}
