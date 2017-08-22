package song.questionbank.leetcode_niuke;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2017/8/17.
 * Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 For example,
 S ="ADOBECODEBANC"
 T ="ABC"
 Minimum window is"BANC".
 Note:
 If there is no such window in S that covers all characters in T, return the emtpy string"".
 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 */
//好好看看，阻塞了几天
    //思路：用两个变量，一个存储每个字符匹配的次数，一个存储整体还剩几个没被匹配，n遍历，每次整体匹配完，i对应着当前串的right值，然后再移动左边界，
    //至最合适的地方，对比当前长度与最短长度，决定是否保留当前子串，匹配完了，将左边界向右移一位，抛弃掉上一个合理的解，开始匹配下一个
    //所谓贪心，每次将当前结果作为最好的，实现方式是用变量记录全局最优成果，如这里的min(最短长度)，然后每次搜索时，都不管其他的，只不过匹配到了就和
    //这个值比一比，看是不是更优值
public class Solution73 {
    public String minWindow(String S, String T) {
        int[] srcHash = new int[255];
        // 记录目标字符串每个字母出现次数
        for(int i = 0; i < T.length(); i++){
            srcHash[T.charAt(i)]++;
        }
        int start = 0,i= 0;
        // 用于记录窗口内每个字母出现次数
        int[] destHash = new int[255];
        int found = 0;
        int begin = -1, end = S.length(), minLength = S.length();
        for(start = i = 0; i < S.length(); i++){
            // 每来一个字符给它的出现次数加1
            destHash[S.charAt(i)]++;
            // 如果加1后这个字符的数量不超过目标串中该字符的数量，则找到了一个匹配字符
            if(destHash[S.charAt(i)] <= srcHash[S.charAt(i)]) found++;
            // 如果找到的匹配字符数等于目标串长度，说明找到了一个符合要求的子串
            if(found == T.length()){
                // 将开头没用的都跳过，没用是指该字符出现次数超过了目标串中出现的次数，并把它们出现次数都减1
                while(start < i && destHash[S.charAt(start)] > srcHash[S.charAt(start)]){
                    destHash[S.charAt(start)]--;
                    start++;
                }
                // 这时候start指向该子串开头的字母，判断该子串长度
                if(i - start < minLength){
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                // 把开头的这个匹配字符跳过，并将匹配字符数减1
                destHash[S.charAt(start)]--;
                found--;
                // 子串起始位置加1，我们开始看下一个子串了
                start++;
            }
        }
        // 如果begin没有修改过，返回空
        return begin == -1 ? "" : S.substring(begin,end + 1);
    }

    public static String minWindow1(String S, String T) {
        Map<Character,Integer> srcMap = new HashMap<>();
        for(char c:T.toCharArray()){
            if(srcMap.containsKey(c)){
                srcMap.put(c,srcMap.get(c)+1);
            }else{
                srcMap.put(c,1);
            }
        }
        int total = T.length(),left=-1,right=S.length()-1,min=Integer.MAX_VALUE,cur=0;
        for(int i=0;i<S.length();i++){
            char c = S.charAt(i);
            if(!srcMap.containsKey(c)) continue;
            srcMap.put(c,srcMap.get(c)-1);
            if(srcMap.get(c)>= 0){
                total--;
            }
            if(total<=0){
                while (cur<=i){
                    char c1 = S.charAt(cur);
                    if(srcMap.containsKey(c1)) {
                        if (srcMap.get(c1) < 0) {
                            srcMap.put(c1, srcMap.get(c1) + 1);
                        }else break;
                    }
                    cur++;
                }
                if(i-cur<min){
                    min = i-cur;
                    left = cur;
                    right = i;
                }
                srcMap.put(S.charAt(cur),srcMap.get(S.charAt(cur))+1);
                cur++;
                total++;
            }
        }
        return left<0?"":S.substring(left,right+1) ;
    }

    public static void main(String [] args){
        System.out.println(minWindow1("ADOBECODEBANC","ABC"));
    }
}
