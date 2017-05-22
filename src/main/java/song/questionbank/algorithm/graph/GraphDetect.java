package song.questionbank.algorithm.graph;

import song.questionbank.algorithm.AdjcentTable;

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
}
