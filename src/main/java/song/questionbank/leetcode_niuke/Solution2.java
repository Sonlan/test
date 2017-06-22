package song.questionbank.leetcode_niuke;

import java.util.Stack;

/**
 * Created by Song on 2017/6/22.
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 Valid operators are+,-,*,/. Each operand may be an integer or another expression.
 Some examples:
 ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution2 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<Integer>();
        int temp = 0,var1,var2;
        for(String str:tokens){
            if(isOperator(str)){
                if(stack.size()<2) return -1;
                var2 = stack.pop();
                var1 = stack.pop();
                stack.push(operate(var1,var2,str));
            }else stack.push(Integer.parseInt(str));
        }
        return stack.pop();

    }

    private boolean isOperator(String exp){
        if(exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/"))
            return true;
         return false;
    }

    private int operate(int var1,int var2,String operator){
        if(operator.equals("+")) return var1+var2;
        if(operator.equals("-")) return var1-var2;
        if(operator.equals("*")) return var1*var2;
        if(operator.equals("/") && var2!=0) return var1/var2;
        return -1;
    }

    public static void main(String [] args){
        Solution2 sol = new Solution2();
        System.out.println(sol.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
    }
}
