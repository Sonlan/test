package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/23.
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 How many possible unique paths are there?

 Above is a 3 x 7 grid. How many possible unique paths are there?
 Note: m and n will be at most 100.
 https://www.nowcoder.com/practice/166eaff8439d4cd898e3ba933fbc6358?tpId=46&tqId=29117&tPage=5&rp=5&ru=%2Fta%2Fleetcode&qru=%2Fta%2Fleetcode%2Fquestion-ranking
 */
public class Solution88 {
    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m][n];
        dp[0][0] = 1;
        for(int j=1;j<n;j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<m;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
