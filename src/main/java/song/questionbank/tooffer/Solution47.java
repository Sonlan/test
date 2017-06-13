package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/13.
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）
 *
 * 求和公式：sn = n*a1+n(n-1)*d/2  x
 * 逻辑与的短路特性实现递归终止
 */
public class Solution47 {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean falg = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
