package song.questionbank.leetcode_niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/27.
 * A linked list is given such that each node contains an additional random pointer
 * which could point to any node in the list or null.
 Return a deep copy of the list.
 思路：仔细读题，random节点指向的是列表中的节点，而不会出现经过多个节点才到列表
 所以，可以先复制next，而将random存起来，最后复制random
 */

  class RandomListNode {
      int label;
      RandomListNode next, random;
      RandomListNode(int x) { this.label = x; }
  }


public class Solution13 {
    public RandomListNode copyRandomList(RandomListNode head) {
        if(null == head) return null;
        //存储原节点到现现节点的映射
        Map<RandomListNode,RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode root = new RandomListNode(0);
        RandomListNode p = root;
        RandomListNode temp = head;
        while (null != head){
            p.next = new RandomListNode(head.label);
            map.put(head,p.next);
            head = head.next;
            p = p.next;
        }
        p = root;head = temp;
        while (null != head){
            if(null != head.random)
                p.next.random = map.get(head.random);
            head = head.next;
            p = p.next;
        }
        return root.next;
    }
}
