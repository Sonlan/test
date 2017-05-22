package song.questionbank.tooffer;

import java.util.Stack;

/**
 * Created by Song on 2017/3/9.
 * 栈的压入，弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 解题思路：构建一个辅助栈，按照入栈顺序依次入栈，且每当一个元素入栈，即匹配当前出栈值是否与栈顶想等，等则出栈，直至不等。
 *          依次循环，当遍历完整个入栈数组，若栈为空，则代表出栈顺序正确，否则错误
 */
public class Solution21 {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        Stack<Integer> stack = new Stack<Integer>();
        int j=0;
        if(pushA.length != popA.length) return false;
        for(int i=0;i<pushA.length;i++){
            //压栈
            stack.push(pushA[i]);
            //出栈过程
            while (j<popA.length&&popA[j]==stack.peek()){
                stack.pop();
                j++;
            }
        }
        if(stack.isEmpty()) return true;
        return false;
    }
}
