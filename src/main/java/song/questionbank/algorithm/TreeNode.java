package song.questionbank.algorithm;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Song on 2017/3/23.
 * 树节点（下一兄弟表示法）
 */
public class TreeNode<T> {
    T element;
    TreeNode firstChild;  //第一个子节点
    TreeNode nextSibling; //下一个兄弟节点

    public TreeNode(T element, TreeNode firstChild, TreeNode nextSibling) {
        this.element = element;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }
}
