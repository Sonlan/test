package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/22.
 * Implementint sqrt(int x).
 Compute and return the square root of x.
 */
//牛顿逼近法 http://blog.csdn.net/hyc__/article/details/41117009
public class Solution80 {
    public int sqrt(int x) {
        long r = x;
        while (r*r > x)
            r = (r + x/r) / 2;
        return (int)r;
    }
}
