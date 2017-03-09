package song.tooffer;

import java.util.Stack;

/**
 * Created by Administrator on 2017/3/6.
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
 * 解题思路：每次取值的时候，将目标元素上的所有值都放到2中，取出值后，再放回1中
 * 注意：peek只取值不删值，队列操作取完值则删值
 */
public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack1.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        int res = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        return res;
    }

    public static void main(String [] args){
        Solution5 solution5 = new Solution5();
        solution5.push(1);
        solution5.push(2);
        solution5.push(3);
        System.out.println(solution5.pop());
    }

}
