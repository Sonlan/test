package song.questionbank.tooffer;

/**
 * Created by Song on 2017/3/9.
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数
 * 解题思路：查看了多种别人的实现方式，都是在取出来的时候，去遍历，再次基础上简单点的是使用iterator
 */
import java.util.Iterator;
import java.util.Stack;

public class Solution20 {

    Stack<Integer> stack = new Stack<Integer>();

    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = stack.peek();
        int temp = 0;
        Iterator<Integer> it = stack.iterator();
        while (it.hasNext()){
            temp = it.next();
            if(temp<min)
                min = temp;
        }
        return min;
    }
}
