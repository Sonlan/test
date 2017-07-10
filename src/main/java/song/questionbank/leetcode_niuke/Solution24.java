package song.questionbank.leetcode_niuke;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Song on 2017/7/6.
 * Given two words (start and end), and a dictionary, find all shortest transformation sequence(s) from start to end, such that:
 Only one letter can be changed at a time
 Each intermediate word must exist in the dictionary
 For example,
 Given:
 start ="hit"
 end ="cog"
 dict =["hot","dot","dog","lot","log"]
 Return
 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]

 Note:
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 */
public class Solution24 {
    public static ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        //Map<String,ArrayList<String>> routes = new HashMap<String, ArrayList<String>>();
        Map<String,ArrayList<String>> routes1 = new HashMap<String, ArrayList<String>>();
        StringBuilder sb = new StringBuilder();
        //generateMap(start,end,routes,dict);
        generateMap1(start,end,routes1,dict);

        ArrayList<ArrayList<String>> aa = new ArrayList<ArrayList<String>>();
        ArrayList<String> curList = new ArrayList<String>();
        Set<String> curSet = new HashSet<String>();
        curList.add(start);curSet.add(start);
        //findCore(start,end,routes1,curSet,aa,curList);
        //findCore1(curList,end,routes1,sb);
        findCore2(start,end,routes1,aa,curList);
        //String [] strs = sb.toString().split("#");
        return aa;
    }

    public static void generateMap(String sourceStr,String desStr, Map<String,ArrayList<String>> routes,HashSet<String> dict){
        if(routes.containsKey(sourceStr)) return;
        char [] sourceChars = sourceStr.toCharArray();
        ArrayList<String> tempList = new ArrayList<String>();
        routes.put(sourceStr,tempList);
        for(int i=0;i<sourceChars.length;i++){
            sourceChars = sourceStr.toCharArray();
            String tempStr;
            for(char j = 'a';j<='z';j++){
                sourceChars[i] = j;
                tempStr = new String(sourceChars);
                if(!tempStr.equals(sourceStr) && (dict.contains(tempStr) || desStr.equals(tempStr))){
                    tempList.add(tempStr);
                    generateMap(tempStr,desStr,routes,dict);
                }
            }
        }
        routes.put(sourceStr,tempList);
    }

    public static void findCore(String start,String end,Map<String,ArrayList<String>> routes,Set<String> handledSet,ArrayList<ArrayList<String>> result,ArrayList<String> path){
        if(start.equals(end)){
            if(result.isEmpty()) {
                result.add(new ArrayList<String>(path));
                return;
            }
            if(result.get(0).size()>path.size()) {
                result.clear();
                result.add(new ArrayList<String>(path));
            }else if(result.get(0).size() == path.size()){
                result.add(new ArrayList<String>(path));
            }
            return;
        }
        ArrayList<String> tempList = routes.get(start);
        for(String val:tempList){
            if(!handledSet.contains(val)) {
                path.add(val);
                handledSet.add(val);
                findCore(val, end, routes, handledSet, result, path);
                path.remove(path.size()-1);
                handledSet.remove(val);
            }
        }
    }

    public static void generateMap1(String sourceStr,String desStr, Map<String,ArrayList<String>> routes,HashSet<String> dict){
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

    public static void findCore1(ArrayList<String> curList,String end,Map<String,ArrayList<String>> routes,StringBuilder result){
        ArrayList<String> nextList = new ArrayList<String>();
        nextList.add("#");
        boolean find = false;
        for(String str:curList){
            result.append(str);
            if(str.equals(end)) find=true;
            if(find) continue;
            if(str.equals("*") || str.equals("#")) continue;
            ArrayList<String> temp = routes.get(str);
            nextList.add("*");
            if(null == temp || temp.size()==0) continue;
            nextList.addAll(routes.get(str));
        }
        if(!find){
            findCore1(nextList, end, routes, result);
        }
    }

    public static void findCore2(String start,String end,Map<String,ArrayList<String>> routes,ArrayList<ArrayList<String>> result,ArrayList<String> path){
        if(start.equals(end)){
            if(result.isEmpty()) {
                result.add(new ArrayList<String>(path));
                return;
            }
            if(result.get(0).size()>path.size()) {
                result.clear();
                result.add(new ArrayList<String>(path));
            }else if(result.get(0).size() == path.size()){
                result.add(new ArrayList<String>(path));
            }
            return;
        }
        ArrayList<String> tempList = routes.get(start);
        for(String val:tempList){
            path.add(val);
            findCore2(val, end, routes, result, path);
            path.remove(path.size() - 1);
        }
    }

    public static void findCore3(String start,String end,Map<String,ArrayList<String>> routes,ArrayList<ArrayList<String>> result) {

    }

        public static void main(String [] args){
        Solution24 sol = new Solution24();
        HashSet<String> dict = new HashSet<String>();
        dict.add("hot");dict.add("dot");dict.add("dog");
        dict.add("lot");dict.add("log");
        System.out.println(sol.findLadders("hit","cog",dict));
    }
    /**
     *  start ="hit"
     end ="cog"
     dict =["hot","dot","dog","lot","log"]
     Return
     [
     ["hit","hot","dot","dog","cog"],
     ["hit","hot","lot","log","cog"]
     ]
     */

}
