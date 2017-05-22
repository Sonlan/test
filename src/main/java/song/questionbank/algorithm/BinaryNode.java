package song.questionbank.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Song on 2017/3/23.
 * 二叉树节点
 */
public class BinaryNode<T> {
    T element;
    BinaryNode left;
    BinaryNode right;

    public BinaryNode(T element, BinaryNode left, BinaryNode right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
