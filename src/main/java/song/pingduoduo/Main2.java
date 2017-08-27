package song.pingduoduo;

import java.util.Stack;

/**
 * Created by Song on 2017/8/27.
 */
public class Main2 {

    public static boolean isValid(String str){
        Stack<Character> stack = new Stack<>();
        int exist1 = 0,exist2 = 0,exist3 = 0;
        for (char c:str.toCharArray()){
            if(c == '{' ) {
                if(exist2!=0 || exist3!=0) return false;
                stack.push(c);exist1 ++;
            }
            else if(c == '[') {
                if(exist3!=0) return false;
                stack.push(c);exist2 ++;
            }
            else if(c == '(') {
                stack.push(c);exist3 ++;
            }else if(c == ')'){
                if(stack.isEmpty() || stack.pop()!= '(') return false;
                exist3--;
            }else if(c == ']'){
                if(stack.isEmpty() || stack.pop()!= '[') return false;
                exist2--;
            }else if(c == '}'){
                if(stack.isEmpty() || stack.pop()!= '{') return false;
                exist1--;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }

    public static void main(String [] args){
        System.out.println(isValid("{[(2+3)*(1-3)] + 4}*(14-3)"));
    }


}
