package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/7.
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 解题思路，参考（8）跳台阶
 */
public class Solution10 {
    public int RectCover(int target) {
        if(0>=target) return 0;
        if(1==target) return 1;
        if(2==target) return 2;
        return RectCover(target-1)+RectCover(target-2);
    }
}
