package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/22.
 * You are climbing a stair case. It takes n steps to reach to the top.
 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
//爬楼梯，动态规划
public class Solution79 {
    public int climbStairs(int n) {
        if(n<0) return 0;
        if(n ==1) return 1;
        if(n == 2) return 2;
        int [] dp = new int[n+1];
        dp[0] = 0; dp[1] = 1;dp[2] = 2;
        for(int i=3;i<n+1;i++){
            //按最后一步，可以跨几级来分类
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
