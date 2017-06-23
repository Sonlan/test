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
      //试图从全局去统计时，发现得处理各种重复情况，参考答案，只记录单次最大即可
    public int maxPoints(Point[] points) {
        if(null == points) return -1;
        if(2>=points.length) return points.length;
        Map<Float,Integer> map =new HashMap<Float, Integer>();
        float temp ;
        int y,x;
        int same = 0;
        int vertival = 0;
        int horizonal = 0;
        int max = 1,curMax = 0;
        for(int i=0;i<points.length-1;i++){
            same = 0;
            vertival = 0;
            horizonal = 0;
            curMax = 1;
            map.clear();
            for(int j=0;j<points.length;j++) {
                if (j != i) {
                    y = points[j].y - points[i].y;
                    x = points[j].x - points[i].x;
                    if (y == 0 && x == 0) {
                        same += 1;
                    } else if (y == 0) {//水平
                        if (horizonal == 0) horizonal = 2;
                        else horizonal++;
                    } else if (x == 0) {//垂直
                        if (vertival == 0) vertival = 2;
                        else vertival++;
                    } else {//普通
                        temp = y * 1.0f / x; //有正负0,所以水平的单独拿出来了
                        if (map.containsKey(temp)) map.put(temp, map.get(temp) + 1);
                        else map.put(temp, 2);
                        curMax = curMax>map.get(temp)?curMax:map.get(temp);
                    }
                }
            }
            curMax+=same;
            max = max>(horizonal+same)?max:(horizonal+same);
            max = max>(vertival+same)?max:(vertival+same);
            max = max>curMax?max:curMax;
        }
        return max;
    }

    public static void main(String [] args){
        Solution3 sol = new Solution3();
        System.out.println(sol.maxPoints(new Point[]{new Point(2,3),new Point(3,3),new Point(-5,3)}));
    }
}
