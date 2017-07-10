package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/7/10.
 */
import java.util.*;
public class Solution25_1 {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        //思路：双端HashSet,将其分为起始集合和结束集合，当起始集合中的单词变换一次后得到结束集合中的某词时可以结束
        //当起始、结束集合中有任意一个为空时，总的也为空
        //由于只有26个字母，因此，采用字母替换法所能达到的26*n在n较大时远远优于n*n
        //init
        HashSet<String> beginSet=new HashSet<String>();
        HashSet<String> endSet=new HashSet<String>();
        HashSet<String> visited=new HashSet<String>();

        beginSet.add(start);
        endSet.add(end);
        visited.add(start);
        int res=1;

        while(!beginSet.isEmpty()&&!endSet.isEmpty()){
            //保证每次对较少数目的endSet做处理
            if(beginSet.size()>endSet.size()){
                HashSet<String> temp=beginSet;
                beginSet=endSet;
                endSet=temp;
            }

            HashSet<String> temp=new HashSet<String>();

            for(String str:beginSet){
                char[] chs=str.toCharArray();
                for(int i=0;i<chs.length;i++){
                    char old=chs[i];
                    for(char ch='a';ch<='z';ch++){
                        chs[i]=ch;
                        String cur=String.valueOf(chs);
                        if(endSet.contains(cur)){
                            return res+1;
                        }
                        if(!visited.contains(cur)&&dict.contains(cur)){
                            temp.add(cur);
                            visited.add(cur);
                        }
                    }
                    chs[i]=old;
                }

            }
            beginSet=temp;
            res++;
        }
        return 0;
    }
}


