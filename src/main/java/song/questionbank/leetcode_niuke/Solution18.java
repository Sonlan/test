package song.questionbank.leetcode_niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/29.
 * Clone an undirected graph. Each node in the graph contains a label and a list of itsneighbors.

 OJ's undirected graph serialization:
 Nodes are labeled uniquely.
 We use#as a separator for each node, and,as a separator for node label and each neighbor of the node.

 As an example, consider the serialized graph{0,1,2# 1,2# 2,2}.
 The graph has a total of three nodes, and therefore contains three parts as separated by#.
 First node is labeled as0. Connect node0to both nodes1and2.
 Second node is labeled as1. Connect node1to node2.
 Third node is labeled as2. Connect node2to node2(itself), thus forming a self-cycle.

 Visually, the graph looks like the following:
 1
 / \
 /   \
 0 --- 2
 / \
 \_/
 */
  class UndirectedGraphNode {
      int label;
      ArrayList<UndirectedGraphNode> neighbors;
      UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  }

public class Solution18 {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(null == node) return null;
        Map<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        return cloneGraphCore(map,node);
    }
    public UndirectedGraphNode cloneGraphCore(Map<UndirectedGraphNode,UndirectedGraphNode> map,UndirectedGraphNode node){
        if(null == node) return null;
        if(map.containsKey(node)) return map.get(node);
        UndirectedGraphNode p = new UndirectedGraphNode(node.label);
        map.put(node,p);
        ArrayList<UndirectedGraphNode> neighbors = node.neighbors;
/*        if(null != neighbors){
            ArrayList<UndirectedGraphNode> newNeighbors = new ArrayList<UndirectedGraphNode>();
            for(UndirectedGraphNode neighbor:neighbors){
                if(map.containsKey(neighbor)) {
                    newNeighbors.add(map.get(neighbor));
                    continue;
                }
                UndirectedGraphNode temp = new UndirectedGraphNode(neighbor.label);
                map.put(neighbor,temp);
                newNeighbors.add(temp);
                cloneGraphCore(map, neighbor);//与前几行重复
            }
            p.neighbors = newNeighbors;
        }*/
        if(null != neighbors){
            for(UndirectedGraphNode neighbor:neighbors){
                p.neighbors.add(cloneGraphCore(map, neighbor));
            }
        }
        return p;
    }

    public static void main(String [] args){
        Solution18 sol = new Solution18();
        UndirectedGraphNode node1 = new UndirectedGraphNode(0);
        UndirectedGraphNode node2 = new UndirectedGraphNode(0);
        UndirectedGraphNode node3 = new UndirectedGraphNode(0);
        ArrayList<UndirectedGraphNode>  list = new ArrayList<UndirectedGraphNode>();
        list.add(node2);list.add(node3);
        node1.neighbors = list;
        UndirectedGraphNode result = sol.cloneGraph(node1);
        System.out.println();

    }
}
