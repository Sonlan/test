package song.questionbank.tooffer;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Song on 2017/6/10.
 * 在一个字符串(1<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置
 */
public class Solution34 {
    public int FirstNotRepeatingChar(String str) {
        Map<Character,Integer> map = new LinkedHashMap<Character, Integer>();
        for(char c:str.toCharArray()){
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else map.put(c,1);
        }
        for(Character c:map.keySet()){
            if(map.get(c)==1)
                return str.indexOf(c);
        }
        return -1;
    }

    public static void main(String [] args){
        System.out.println(new Solution34().FirstNotRepeatingChar("abacbdee"));
    }
}
