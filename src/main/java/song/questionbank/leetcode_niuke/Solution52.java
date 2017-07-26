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
public class Solution52 {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s3.length()!=s1.length()+s2.length()) return false;
        boolean [][][] data = new boolean[s3.length()][s1.length()][s2.length()];
        int index1=0,index2=0;
        for(int i=0;i<s3.length();i++){
            if(s1.charAt(index1) == s3.charAt(i)){
                data[i][index1][index2] = true;
            }
        }
        return true;
    }
}
