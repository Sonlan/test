package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/29.
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 Return the minimum cuts needed for a palindrome partitioning of s.
 For example, given s ="aab",
 Return 1 since the palindrome partitioning["aa","b"]could be produced using 1 cut.

 解题思路：动态规划问题。参考
 dp[i] - 表示子串（0，i）的最小回文切割，则最优解在dp[s.length-1]中。
 分几种情况：
 1.初始化：当字串s.substring(0,i+1)(包括i位置的字符)是回文时，dp[i] = 0(表示不需要分割)；否则，dp[i] = i（表示至多分割i次）;
 2.对于任意大于1的i，如果s.substring(j,i+1)(j<=i,即遍历i之前的每个子串)是回文时，dp[i] = min(dp[i], dp[j-1]+1);
 3.如果s.substring(j,i+1)(j<=i)不是回文时，dp[i] = min(dp[i],dp[j-1]+i+1-j);
 */
public class Solution19 {

    //超内存
   /* public int minCut(String s) {
        int[] dp = new int[s.length()];
        for(int i=0;i<s.length();i++){
            dp[i] = isPalindrome(s.substring(0, i+1))?0:i;
            if(dp[i] == 0)
                continue;
            for(int j=1;j<=i;j++){
                if(isPalindrome(s.substring(j, i+1)))
                    dp[i] = Math.min(dp[i], dp[j-1]+1);
                else
                    dp[i] = Math.min(dp[i], dp[j-1]+i+1-j);
            }
        }
        return dp[dp.length-1];
    }*/
//超内存
/*    public int minCut(String s) {
        if(null == s || s.length()<=1) return 0;
        int [] count = new int[s.length()];
        int temp;
        for(int i=0;i<s.length();i++){
            for(int j=i+1;j<=s.length();j++){
                if(i==0) {
                    count[j-1] = isPalindrome(s.substring(i, j))? 0:j-1;
                }else {
                    temp = isPalindrome(s.substring(i,j))?count[i-1]+1:count[i-1]+j-i;
                    count[j-1] = count[j-1]<temp?count[j-1]:temp;
                }
            }
        }
        return count[s.length()-1];
    }*/

    public boolean isPalindrome(String str){
        char [] chars = str.toCharArray();
        if(str.length()<=1) return true;
        int start = 0,end = str.length()-1;
        while (start<end){
            if(chars[start++] != chars[end--])
                return false;
        }
        return true;
    }

    public int minCut(String s) {
        if (s == null || s.length() <= 1){
            return 0;
        }
        int n = s.length();
        int i,j;
        int[] minCut = new int[n + 1];
        for (i = 0; i < n + 1; i++){
            minCut[i] = i - 1;
        }
        for(i = 1; i < n; i++){
            //以i为中心，向两边比对，直到不对称为止
            // odd-length
            for (j = 0; i - j >= 0 && i + j < n && s.charAt(i - j) == s.charAt(i + j); j++){
                minCut[i + j + 1] = Math.min(minCut[i + j + 1], minCut[i - j] + 1);
            }
            // even-length
            for (j = 0; i - j - 1 >= 0 && i + j < n && s.charAt(i - j - 1) == s.charAt(i + j); j++){
                minCut[i + j + 1] = Math.min(minCut[i + j + 1], minCut[i - j - 1] + 1);
            }
        }
        return minCut[n];
    }

    public static void main(String [] args){
        Solution19 sol = new Solution19();
        System.out.println(sol.minCut("abcb"));
    }
}
