package song.leetcode;

import java.util.regex.Pattern;

/**
 * Created by Song on 2016/11/14.
 * Implement regular expression matching with support for '.' and '*'.

 '.' Matches any single character.
 '*' Matches zero or more of the preceding element.

 The matching should cover the entire input string (not partial).

 The function prototype should be:
 bool isMatch(const char *s, const char *p)

 Some examples:
 isMatch("aa","a") → false
 isMatch("aa","aa") → true
 isMatch("aaa","aa") → false
 isMatch("aa", "a*") → true
 isMatch("aa", ".*") → true
 isMatch("ab", ".*") → true
 isMatch("aab", "c*a*b") → true
 */
public class Solution10 {
    public boolean isMatch(String s, String p) {
        //记录s当前匹配的位置
        return s.matches(p);
    }

    public static void main(String [] args){
        System.out.println(new Solution10().isMatch("aab","c*a*b"));
    }
}
