package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/6/29.
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 Return all possible palindrome partitioning of s.
 For example, given s ="aab",
 Return
 [
 ["aa","b"],
 ["a","a","b"]
 ]
 */
public class Solution20 {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> reslut = new ArrayList<ArrayList<String>>();
        partitionCore(reslut,new ArrayList<String>(),s);
        return reslut;
    }

    private void partitionCore(ArrayList<ArrayList<String>> result,ArrayList<String> temp,String s){
        if(null == s || 0== s.length()){
            result.add(new ArrayList<String>(temp));
            return;
        }
        for(int i=1;i<=s.length();i++){
            if(isPalindrome(s.substring(0,i))){
                ArrayList<String> list = new ArrayList<String>(temp);
                list.add(s.substring(0,i));
                partitionCore(result, list, s.substring(i,s.length()));
            }
        }
    }

    private boolean isPalindrome(String s){
        if(null ==s ) return false;
        int i=-1,j = s.length();
        while ((++i)<(--j)){
            if(s.charAt(i) != s.charAt(j))
                return false;
        }
        return true;
    }

    public static void main(String [] args){
        Solution20 sol = new Solution20();
        System.out.println(sol.partition("aab"));
    }
}
