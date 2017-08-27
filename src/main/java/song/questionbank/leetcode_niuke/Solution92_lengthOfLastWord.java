package song.questionbank.leetcode_niuke;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * Created by Song on 2017/8/23.
 * Given a string s consists of upper/lower-case alphabets and empty space characters' ', return the length of last word in the string.
 If the last word does not exist, return 0.
 Note: A word is defined as a character sequence consists of non-space characters only.
 For example,
 Given s ="Hello World",
 return5.
 */
//无任何价值
public class Solution92_lengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if(null == s) return 0;
        String [] str = s.split(" ");
        if(str.length==0) return 0;
        return str[str.length-1].length();
    }
}
