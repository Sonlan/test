package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/26.
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 For example,
 Given:
 s1 ="aabcc",
 s2 ="dbbca",
 When s3 ="aadbbcbcac", return true.
 When s3 ="aadbbbaccc", return false.
 */
//挺不错，看看递归与动态规划
public class Solution52 {
/*    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false;
        boolean [][][] data = new boolean[s3.length()][s1.length()][s2.length()];
        int index1=0,index2=0;
        int pos1=0,pos2=0;
        for(int i=0;i<s3.length();i++){
            if(s1.charAt(index1) == s3.charAt(i)){
                if(s2.charAt(index2) == s3.charAt(i)){
                    pos1 = index1-1>=0?index1-1:0;
                    pos2 = index2-1>=0?index2-1:0;
                    data[i][pos1][index2] = true;
                    data[i][index1][pos2] = true;
                }else {
                    data[i][index1][index2] = true;
                    index1++;
                }
            }else {
                if(s2.charAt(index2) == s3.charAt(i)){
                    data[i][index1][index2] = true;
                    index2++;
                }else {

                }
            }
        }
        return true;
    }*/

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false;
        boolean [][] dp = new boolean[s1.length()+1][s2.length()+1];
        return isInterleaveCore(s1,s2,s3,0,0,0,dp);
    }
    public boolean isInterleaveCore(String s1, String s2, String s3,int index1,int index2,int index3,boolean [][] dp) {
        if(index1 == s1.length() && index2 == s2.length() && index3 == s3.length()) return true;
        if(index1 > s1.length() || index2 > s2.length() || index3 > s3.length()) return false;
        boolean flag1 = false,flag2=false;
        if(index1<s1.length() && index3<s3.length()){
            if(s3.charAt(index3) == s1.charAt(index1)){
                dp[index1+1][index2] = true;
                flag1 = isInterleaveCore(s1, s2, s3, index1+1, index2, index3+1,dp);
            }
        }
        if(index2<s2.length() && index3<s3.length()){
            if(s3.charAt(index3) == s2.charAt(index2)){
                dp[index1][index2+1] = true;
                flag2 = isInterleaveCore(s1, s2, s3, index1, index2+1, index3+1,dp);
            }
        }
        return flag1||flag2;
    }

    public boolean isInterleave1(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        //i+j用于标识s3的前i+j位能否匹配
        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
        dp[0][0] = true;
        for(int i=1;i<=s2.length();i++){
            dp[0][i] = s3.charAt(i-1) == s2.charAt(i-1);
        }
        for(int i=1;i<=s1.length();i++){
            dp[i][0] = s3.charAt(i-1) == s1.charAt(i-1);
        }
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                dp[i][j] = (dp[i-1][j] && s1.charAt(i-1)==s3.charAt(i+j-1))
                        || (dp[i][j-1] && s2.charAt(j-1) == s3.charAt(i+j-1));
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public static void main(String [] args){
        Solution52 sol = new Solution52();
        System.out.println(sol.isInterleave1("aabcc","dbbca","aadbbbaccc"));
    }
/*    s1 ="aabcc",
    s2 ="dbbca",
    When s3 ="aadbbcbcac", return true.
    When s3 ="aadbbbaccc", return false.*/
}
