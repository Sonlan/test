package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/7.
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 解题思路：同上一题，按照最后一跳的步数来分，最后一跳有n种，结果为其总和
 */
public class Solution9 {
    public int JumpFloorII(int target) {
        if(1>=target) return 1;
        int res = 0;
        for(int i=target;i>0;i--){
            res+=JumpFloorII(target-i);
        }
        return res;
    }
}
