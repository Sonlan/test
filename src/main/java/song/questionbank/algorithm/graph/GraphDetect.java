package song.questionbank.algorithm.graph;

import song.questionbank.algorithm.AdjcentTable;
import song.questionbank.algorithm.GraphMatrix;

import java.util.*;

/**
 * Created by Song on 2017/4/19.
 */
public class GraphDetect {
    public static AdjcentTable<String> getAdjcentTable(int [][] distances){
        AdjcentTable<String> adjcentTable = new AdjcentTable<String>();
        int height = distances.length;
        int weight = distances[0].length;
        return adjcentTable;
    }

    /**
     * 求最小生成树
     * @param GM 权重矩阵
     * @param initVertex 初始点
     */
    public  void primGraph(GraphMatrix GM,int initVertex){
        if(initVertex>=GM.size) return;

        int [] handlerMatrix = new int[GM.size];
        String [] path = new String[GM.size];

        String [] vertex = GM.getVertex();
        int [][] weights = GM.getEdgeWeight();

        for(int i=0;i<GM.size;i++){
            handlerMatrix[i] = -1;
            path[i] = "";
        }

        handlerMatrix[initVertex] = 1;
        path[initVertex] = "root";

        for(int i=0;i<GM.size;i++){
            int index = -1;
            int fatherIndex = -1;
            int temp = 1000;
            for(int j=0;j<GM.size;j++) {
                if (handlerMatrix[j]>0) {
                    int nextIndex = findMinIndex(GM.getCol(j), handlerMatrix);
                    if(nextIndex>0) {
                        if(weights[nextIndex][j]<temp) {
                            temp = weights[nextIndex][j];
                            index = nextIndex;
                            fatherIndex = j;
                        }
                    }
                }
            }
            if(index>0) {
                handlerMatrix[index] = 1;
                path[index] = vertex[fatherIndex];
                System.out.println(vertex[fatherIndex] + "--->" + vertex[index]);
            }
        }

    }

    private int findMinIndex(int [] weights,int [] tempMatrix){
        if(null == weights || 0>= weights.length) return -1;
        int index = -1;
        for(int i = 1;i<weights.length;i++){
            if(tempMatrix[i]<0) {
                if(index<0) {
                    index = i;
                    continue;
                }
                if (weights[i] < weights[index]) {
                    index = i;
                }
            }
        }
        return index;
    }

    public static void main(String [] args){
        int [][] weights = new int[][]{
                {0,2,5,1000,3},
                {2,0,1000,4,1000},
                {5,1000,0,1000,5},
                {1000,4,1000,0,2},
                {3,1000,5,2,0}};
        String [] vertex = new String[]{"A","B","C","D","E"};
        GraphMatrix GM = new GraphMatrix(5);
        GM.setEdgeWeight(weights);
        GM.setVertex(vertex);
        new GraphDetect().primGraph(GM,0);
    }
}
