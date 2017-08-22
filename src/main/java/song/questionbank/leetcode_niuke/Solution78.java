package song.questionbank.leetcode_niuke;

import java.util.Stack;

/**
 * Created by Song on 2017/8/22.
 * Given an absolute path for a file (Unix-style), simplify it.
 For example,
 path ="/home/", =>"/home"
 path ="/a/./b/../../c/", =>"/c"
 click to show corner cases.
 Corner Cases:

 Did you consider the case where path ="/../"?
 In this case, you should return"/".
 Another corner case is the path might contain multiple slashes'/'together, such as"/home//foo/".
 In this case, you should ignore redundant slashes and return"/home/foo".
 */
public class Solution78 {
    public static String simplifyPath(String path) {
        String [] source = path.split("/");
        if(0 == source.length) return "/";
        Stack<String> stack = new Stack<>();
        for(String str:source){
            if(str.equals("")) continue;
            if(str.equals(".")){
                if(stack.isEmpty()) stack.push("");
                else continue;
            }else if(str.equals("..")) {
                if(stack.isEmpty()) stack.push("");
                else stack.pop();
            }else stack.push(str);
        }
        if(stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder();
        String cur;
        while (!stack.isEmpty()){
            cur = stack.pop();
            if(cur.equals("") && sb.length()!=0) continue;
            sb.insert(0,"/"+cur);
        }
        return sb.toString();
    }

    public static void main(String [] args){
        System.out.println(simplifyPath("/."));
    }
}
