package song.questionbank.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Song on 2017/4/18.
 * 邻接表
 */
public class AdjcentTable<T> {
    private Map<T,List<Entry<T>>> graph = new HashMap<T, List<Entry<T>>>();

    public AdjcentTable(){}

    /**
     * 添加邻接节点
     * @param curName 当前节点
     * @param nextName 下一节点
     * @param weight 权值
     * @return 当前节点的邻接节点
     */
    public List<Entry<T>> add(T curName,T nextName,int weight){
        List<Entry<T>> list = this.graph.get(curName);
        if(null == list){
            list = new ArrayList<Entry<T>>();
        }
        list.add(new Entry<T>(nextName,weight));
        this.graph.put(curName,list);
        return list;
    }
    public List<Entry<T>> add(T curName,T nextName){
        return add(curName, nextName,1);
    }

    public List<Entry<T>> get(T curName){
        return this.graph.get(curName);
    }

    public int size(){
        return this.graph.size();
    }

    public boolean contains(T curName){
        return this.graph.containsKey(curName);
    }

    public Map<T,List<Entry<T>>> getGraph(){
        return this.graph;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        for(T key:this.getGraph().keySet()){
            List<Entry<T>> entries = this.get(key);
            sb.append(key+" : "+entries.toString()+"\n");
        }
        return sb.toString();
    }



    class Entry<T>{
        private T name;
        private int weight;

        public Entry(T name, int weight) {
            this.name = name;
            this.weight = weight;
        }

        public T getName() {
            return name;
        }

        public void setName(T name) {
            this.name = name;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
