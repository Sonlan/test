package song.questionbank.leetcode_niuke;


import java.util.*;

/**
 * Created by Song on 2017/6/23.
 *
 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
 Return all such possible sentences.
 For example, given
 s ="catsanddog",
 dict =["cat", "cats", "and", "sand", "dog"].
 A solution is["cats and dog", "cat sand dog"].
 思路：（1）先扫描得到，起始位置为i,终止位置为j的位置中，那些可以凑成单词。
 （2）扫描（1）中的可以得到的单词，所有起止位置涵盖整个字符串即可 凑成一句话

 思路进化：上述代码见注释，纯递归，超时，引入动态规划观念，即将递归的每步结果存下来，而不需要重复运算。此处用了一个map，存储的为第i位到末尾的单词组合，具体值
 开始为List,后测试，发现在极端情况下有重复，例如“aaaaaaa" ["aaaa","aa","a"],所以换为了Set，至于为什么不是hashSet是因为牛客上还要认顺序，
 基于这种思路，就只能倒着遍历了，先扔进去，再考虑其他的，不过也可以改为顺着的，思想一致就行
 */
public class Solution11 {
/*    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if(null ==s || 0==s.length()) return result;
        wordBreakCore(s,0,dict,"",result);
        return result;
    }

    public void wordBreakCore(String s,int start,Set<String> dict,String temp,ArrayList<String> result){
        if(start>=s.length()) {
            result.add(temp.substring(0,temp.length()-1));
            return;
        }
        for(int i=start+1;i<=s.length();i++){
            if(dict.contains(s.substring(start,i))){
                wordBreakCore(s,i,dict,temp+s.substring(start,i)+" ",result);
            }
        }
    }*/

    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        ArrayList<String> result = new ArrayList<String>();
        if(null ==s || 0==s.length()) return result;
        Map<Integer,Set<String>> map = new HashMap<Integer, Set<String>>();
        wordBreakCore(s,s.length(),dict,map);
        if(map.containsKey(0)) {
            Set<String> stringSet = map.get(0);
            Iterator<String> iterator = stringSet.iterator();
            while (iterator.hasNext()){
                result.add(iterator.next());
            }
        }
        return result;
    }

    public void wordBreakCore(String s,int end,Set<String> dict,Map<Integer,Set<String>> map){
        for(int i=end-1;i>=0;i--){
            if(dict.contains(s.substring(i,end))){
                if(map.containsKey(end)){
                    Set<String> tempSet = map.get(end);
                    Set<String> newSet = new LinkedHashSet<String>();
                    if(map.containsKey(i))
                        newSet = map.get(i);
                    Iterator<String> iterator = tempSet.iterator();
                    while (iterator.hasNext()){
                        newSet.add(s.substring(i,end)+" "+iterator.next());
                    }
                    map.put(i,newSet);
                }else{
                    if(end>=s.length()){
                        Set<String> tempSet = new LinkedHashSet<String>();
                        tempSet.add(s.substring(i,s.length()));
                        map.put(i,tempSet);
                    }
                }
                wordBreakCore(s,i,dict,map);
            }
        }
    }

    public static void main(String [] args){
        Set<String> dict = new HashSet<String>();
        dict.add("cat");dict.add("cats");
        dict.add("and");dict.add("sand");
        dict.add("dog");
        Solution11 sol = new Solution11();
        ArrayList<String> result = sol.wordBreak("catsanddog",dict);
        System.out.println(result);

    }


}
