package song.pingduoduo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/8/27.
 */
public class Main4 {

    //思路，从小至大，依次取出所有数组元素中最小的那个，记录下属于哪一个数组，转化成为一个最小子串长度统计的问题
    public  String findRegion(ArrayList<int []> list){
        //这里偷懒了，没有使用归并排序
        ArrayList<Item> tmpList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            int [] a = list.get(i);
            for(int val:a) {
                Item item = new Item(val,i);
                tmpList.add(item);
            }
        }
        tmpList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.getVal()-o2.getVal();
            }
        });

        int left=Integer.MAX_VALUE,right=0,len=Integer.MAX_VALUE;
        int total = list.size();
        int tmpSize,start=0;
        Map<Integer,Integer> map = new HashMap<>();
        Item cur;
        for(int i=0;i<tmpList.size();i++){
            cur = tmpList.get(i);
            if(map.containsKey(cur.getType())){
                map.put(cur.getType(),map.get(cur.getType())+1);
            }else {
                map.put(cur.getType(),1);
                total--;
            }
            if(total==0){
                tmpSize = cur.getVal()-tmpList.get(left).getVal();
                if(tmpSize<len){
                    left = start;
                    right = i;
                    len = tmpSize;
                    while (total ==0){
                        start++;
                        cur = tmpList.get(start);
                        if(map.containsKey(cur.getType()) && map.get(cur.getType())>=1){
                            map.put(cur.getType(),map.get(cur.getType())-1);
                            total++;
                        }else break;
                    }
                }
            }
        }
        return "["+left+","+right+"]";
    }

     class Item{
         int val;  //元素值
         int type; //元素属于哪一个数组

         public Item(int val, int type) {
             this.val = val;
             this.type = type;
         }

         public int getVal() {
             return val;
         }

         public void setVal(int val) {
             this.val = val;
         }

         public int getType() {
             return type;
         }

         public void setType(int type) {
             this.type = type;
         }
     }
}
