package song.tooffer;

/**
 * Created by Administrator on 2017/3/6.
 * 跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法
 * 解题思路：递归思想，一级楼梯有1种方法，两级有2种方法，大于两级的，按最后一跳分类，即等于最后一跳为2+最后一跳为1
 */
public class Solution8 {
    public int JumpFloor(int target) {
        if(0>=target) return -1;
        if(1==target) return 1;
        if(2==target) return 2;
        return JumpFloor(target-2)+JumpFloor(target-1);
    }
}
