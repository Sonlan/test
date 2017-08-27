package song.pingduoduo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Song on 2017/8/27.
 */
public class Main3 {
    public static boolean move(int derection,int i,int j){
        return false;
    }
    //即求最大的联通区域
    public static int findTotalArea(){
        //用于存储已走过的格子坐标
        Set<String> set = new HashSet<>();
        findTotalAreaCore(0,0,set);
        return set.size();
    }

    public static void findTotalAreaCore(int i,int j,Set<String> set){
        set.add("("+i+","+j+")");
        if(!set.contains("("+i+","+j+1+")") &&move(0,i,j)){
            findTotalAreaCore(i,j+1,set);
        }
        if(!set.contains("("+i+","+(j-1)+")") &&move(1,i,j)){
            findTotalAreaCore(i,j-1,set);
        }
        if(!set.contains("("+(i-1)+","+j+")") &&move(2,i,j)){
            findTotalAreaCore(i-1,j,set);
        }
        if(!set.contains("("+(i+1)+","+j+")") &&move(3,i,j)){
            findTotalAreaCore(i+1,j,set);
        }
    }
}
