package song.questionbank.leetcode_niuke;

import java.util.*;

/**
 * Created by Song on 2017/6/27.
 * Given a string s and a dictionary of words dict,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 For example, given
 s ="leetcode",
 dict =["leet", "code"].
 Return true because"leetcode"can be segmented as"leet code".
 思路跟上一题一样，不直接递归，引入动态规划思想,这一次我正序来做,则map存储的是开头到i位置是否可以被分解
 思路进化：仍然超时，改成下面的非递归算法
 */
public class Solution12 {
/*    public boolean wordBreak(String s, Set<String> dict) {
        if(null == s || 0== s.length()) return false;
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        wordBreakCore(s,0,dict,map);
        if(map.containsKey(s.length())) return true;
        return false;
    }

    private void wordBreakCore(String s, int start, Set<String> dict, Map<Integer,Boolean> map){
        for(int i=start+1;i<=s.length();i++){
            if(dict.contains(s.substring(start,i))){
                if(map.containsKey(start) || start ==0){
                    map.put(i,true);
                    wordBreakCore(s, i, dict, map);
                }
            }
            if(map.containsKey(s.length())) break;
        }
    }*/

    public boolean wordBreak(String s, Set<String> dict) {
        if(null == s || 0== s.length()) return false;
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        for(int i=1;i<=s.length();i++){
            if(map.containsKey(s.length())) return true;
            if(map.size()!=0){
                for(int key:map.keySet()){
                    if(dict.contains(s.substring(0,i))||(key<i && dict.contains(s.substring(key,i)))) {
                        map.put(i, true);
                        break;
                    }
                }
            }else if(dict.contains(s.substring(0,i))) {
                map.put(i, true);
            }
        }
        if(map.containsKey(s.length())) return true;
        return false;
    }

    public static void main(String [] args){
        Set<String> dict = new HashSet<String>();
        dict.add("cat");dict.add("cats");
        dict.add("and");dict.add("sand");
        dict.add("dog");
        Solution12 sol = new Solution12();
        System.out.println(sol.wordBreak("catsssanddog",dict));
    }
}
