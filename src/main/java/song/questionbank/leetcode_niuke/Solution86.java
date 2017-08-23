package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/23.
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 Note: You can only move either down or right at any point in time.
 */
//动态规划，由于只能向右和向左，则只于左侧以及上方二者中较小的数有关
public class Solution86 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int [][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int j=1;j<n;j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        for(int i=1;i<m;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]<dp[i][j-1]?(dp[i-1][j]+grid[i][j]):(dp[i][j-1]+grid[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
