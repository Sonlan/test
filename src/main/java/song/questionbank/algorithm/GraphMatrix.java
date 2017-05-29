package song.questionbank.algorithm;

/**
 * Created by Song on 2017/5/29.
 * 图矩阵
 */
public class GraphMatrix {
    public int size;
    String [] vertex;  //节点名
    int gType;  //有向图、无向图
    int [][] edgeWeight; //边值权重
    boolean [] isTrav;  //是否也被处理

    public GraphMatrix(int num){
        this.size = num;
        this.vertex = new String[num];
        this.edgeWeight = new int[num][num];
        this.isTrav = new boolean[num];
        this.init();
    }

    private void init(){
        for(int i=0;i<isTrav.length;i++){
            isTrav[i] = false;
        }
    }

    public String[] getVertex() {
        return vertex;
    }

    public void setVertex(String[] vertex) {
        this.vertex = vertex;
    }

    public int getgType() {
        return gType;
    }

    public void setgType(int gType) {
        this.gType = gType;
    }

    public int[][] getEdgeWeight() {
        return edgeWeight;
    }

    public void setEdgeWeight(int[][] edgeWeight) {
        this.edgeWeight = edgeWeight;
    }

    public boolean[] getIsTrav() {
        return isTrav;
    }

    public void setIsTrav(boolean[] isTrav) {
        this.isTrav = isTrav;
    }

    public int [] getRow(int row){
        if(row>=this.size) return null;
        return edgeWeight[row];
    }

    public int [] getCol(int col){
        if(col>=this.size) return null;
        int [] cols = new int[this.size];
        for(int i=0;i<this.size;i++){
            cols[i] = edgeWeight[i][col];
        }
        return cols;
    }

}
