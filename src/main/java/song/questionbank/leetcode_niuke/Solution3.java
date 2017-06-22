package song.questionbank.leetcode_niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/22.
 * Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 */
  class Point {
      int x;
      int y;
      Point() { x = 0; y = 0; }
      Point(int a, int b) { x = a; y = b; }
  }

public class Solution3 {
    public int maxPoints(Point[] points) {
        if(null == points) return -1;
        if(2>=points.length) return points.length;
        Map<Float,Integer> map =new HashMap<Float, Integer>();
        Map<Float,Integer> map1 =new HashMap<Float, Integer>();
        float temp ;
        int same = 0;
        for(int i=0;i<points.length-1;i++){
            for(int j=i+1;j<points.length;j++){
                if(points[j].y==points[i].y){
                    if(points[j].x==points[i].x) {
                        same++;
                        continue;
                    }else{
                        temp = 0;
                    }
                }else {
                    if(points[j].x==points[i].x) {
                        temp = Float.MAX_VALUE;
                    }else{
                        temp = (points[j].y-points[i].y)*1.0f/(points[j].x-points[i].x);
                    }
                }
                if(map.containsKey(temp)) {
                    if(map1.get(temp)==i)
                         map.put(temp,map.get(temp)+1);
                }else{
                    map.put(temp,2);
                    map1.put(temp,i);
                }
            }
        }
        int maxNum = 0;
        for(float key:map.keySet()){
            if(map.get(key)>maxNum) maxNum = map.get(key);
        }
        return maxNum+same;
    }

    public static void main(String [] args){
        Solution3 sol = new Solution3();
        System.out.println(sol.maxPoints(new Point[]{new Point(2,3),new Point(3,3),new Point(-5,3)}));
    }
}
