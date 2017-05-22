package song.questionbank.tooffer;

/**
 * Created by Song on 2017/3/10.
 * 复杂链表的复制
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 *
 * 这个程序虽然通过了牛客网，然而却是不成立的，它只是复制了random node的值，却没有复制其next  以及 random关系
 */
public class Solution25 {
    /*public RandomListNode Clone(RandomListNode pHead)
    {
        if(null == pHead) return null;
        RandomListNode copyHead = new RandomListNode(0);
        RandomListNode root = new RandomListNode(pHead.label);
        if(null != pHead.random)
            root.random = new RandomListNode(pHead.random.label);
        copyHead.next = root;
        while (null != pHead.next) {
            pHead = pHead.next;
            root.next = new RandomListNode(pHead.label);
            if(null != pHead.random)
                root.next.random = new RandomListNode(pHead.random.label);
            root = root.next;
        }
        return copyHead.next;
    }*/
    public RandomListNode Clone(RandomListNode pHead)
    {
        if(null == pHead) return null;
        RandomListNode root = new RandomListNode(0);
        RandomListNode copy = new RandomListNode(0);
        copy.next = root;
        clone(pHead,root);
        return copy.next;
    }

    private RandomListNode clone(RandomListNode sourceNode,RandomListNode targetNode){
        if(null == sourceNode) return null;
        targetNode = new RandomListNode(sourceNode.label);
        clone(sourceNode.next,targetNode.next);
        clone(sourceNode.random,targetNode.random);
        return targetNode;
    }

    public static void main(String [] args){
        RandomListNode node1 = new RandomListNode(1);
        RandomListNode node2 = new RandomListNode(2);
        RandomListNode node3 = new RandomListNode(3);
        RandomListNode node4 = new RandomListNode(4);
        RandomListNode node5 = new RandomListNode(5);

        node1.next = node2; node1.random = node1;
        node2.next = node3; node2.random = node2;
        node3.next = node4; node3.random = node3;
        node4.next = node5; node5.random = node4;

        RandomListNode root = new Solution25().Clone(node1);
        System.out.println(root);
    }
}
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}