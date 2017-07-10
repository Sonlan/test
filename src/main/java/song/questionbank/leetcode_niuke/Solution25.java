package song.questionbank.leetcode_niuke;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Song on 2017/7/10.
 * Given two words (start and end), and a dictionary, find the length of shortest transformation sequence from start to end, such that:
 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,
 Given:
 start ="hit"
 end ="cog"
 dict =["hot","dot","dog","lot","log"]
 As one shortest transformation is"hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length5.
 Note:
 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class Solution25 {
    public int ladderLength(String start, String end, HashSet<String> dict) {
        Map<String,ArrayList<String>> routes1 = new HashMap<String, ArrayList<String>>();
        generateMap1(start,end,routes1,dict);
        return ladderLengthCore(start, end,routes1);
    }

    public static void generateMap1(String sourceStr, String desStr, Map<String,ArrayList<String>> routes, HashSet<String> dict){
        StringBuilder sb = new StringBuilder();
        Queue<String> queue = new LinkedBlockingQueue<String>();
        queue.add(sourceStr);
        while (!queue.isEmpty()) {
            sourceStr = queue.poll();
            ArrayList<String> list = new ArrayList<String>();
            sb.replace(0, sourceStr.length(), sourceStr);
            for (int i = 0; i < sourceStr.length(); i++) {
                for (char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i, j);
                    if (!routes.containsKey(sb.toString()) && !sourceStr.equals(sb.toString()) && (dict.contains(sb.toString()) || desStr.equals(sb.toString()))) {
                        list.add(sb.toString());
                        if(!desStr.equals(sb.toString())) {
                            routes.put(sb.toString(), null);
                            queue.add(sb.toString());
                        }
                    }
                }
                sb.replace(0, sourceStr.length(), sourceStr);
            }
            routes.put(sourceStr,list);
        }
    }

    public int ladderLengthCore(String start, String end,Map<String,ArrayList<String>> routes){
        int count = 1,curSize = 1,nextSize=0;
        Queue<String> queue = new LinkedBlockingQueue<String>();
        queue.add(start);
        String curStr;
        ArrayList<String> curList;
        while (!queue.isEmpty()){
            curStr = queue.poll();
            curSize--;
            if(curStr.equals(end)) return count;
            curList = routes.get(curStr);
            nextSize+=curList.size();
            if(curSize<=0) {count++;curSize=nextSize;nextSize=0;}
            for(String tmpStr:curList){
                queue.add(tmpStr);
            }
        }
        return 0;
    }


    public static void main(String [] args){
        Solution25 sol = new Solution25();
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");dict.add("dot");dict.add("dog");
        dict.add("lot");dict.add("log");
        System.out.println(sol.ladderLength("hit","cog",dict));
    }
}
