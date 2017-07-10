package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/10.
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 For example,
 "A man, a plan, a canal: Panama"is a palindrome.
 "race a car"is not a palindrome.
 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.
 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Solution26 {
    public boolean isPalindrome(String s) {
        if(null == s || 0== s.length()) return true;
        String copy = s.toLowerCase();
        int i=0,j=copy.length()-1;
        while (i<j){
            if(!isAlphanumeric(copy.charAt(i))){
                i++;
                continue;
            }
            if(!isAlphanumeric(copy.charAt(j))){
                j--;
                continue;
            }
            if(copy.charAt(i)!=copy.charAt(j)) return false;
            i++;j--;
        }
        return true;
    }
    public boolean isAlphanumeric(char c){
        if((c>='a' && c<='z')|| (c>='A' && c<='Z') || (c>='0' && c<='9')) return true;
        return false;
    }
}
