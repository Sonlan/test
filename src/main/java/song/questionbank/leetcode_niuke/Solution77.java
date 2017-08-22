package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/22.
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)
 You have the following 3 operations permitted on a word:
 a) Insert a character
 b) Delete a character
 c) Replace a character
 */
//动态规划，自己做的，其实动态规划题，只需要考虑dp[i][j]与dp[i-1][j],dp[i][j-1],dp[i-1][j-1]的关系
public class Solution77 {
    public int minDistance(String word1, String word2) {
        int m = word1.length(),n=word2.length();
        int [][] dp = new int[m+1][n+1];
        dp[0][0] = 0;
        for(int j=1;j<n+1;j++){
            dp[0][j] = j;
        }
        for(int i=1;i<m+1;i++){
            dp[i][0] = i;
        }
        int arg1,arg2,arg3;
        for(int i = 1;i<m+1;i++){
            for(int j=1; j<n+1;j++){
                //删除
                arg1 = dp[i-1][j]+1;
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    arg2 = dp[i-1][j-1];//不变
                else arg2 = dp[i-1][j-1]+1;//替换
                //新增
                arg3 = dp[i][j-1]+1;
                dp[i][j] = min(arg1,arg2,arg3);
            }
        }
        return dp[m][n];
    }

    public int min(int arg1,int arg2,int arg3){
        int min = arg1<arg2?arg1:arg2;
        min = min<arg3?min:arg3;
        return min;
    }

    public static void main(String [] args){

    }
}
