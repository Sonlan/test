package song.questionbank.leetcode_niuke;

import java.util.Stack;

/**
 * Created by Song on 2017/8/10.
 *
 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 Above is a histogram where width of each bar is 1, given height =[2,1,5,6,2,3].


 The largest rectangle is shown in the shaded area, which has area =10unit.

 For example,
 Given height =[2,1,5,6,2,3],
 return10.

 */
//很经典的，直方图最大矩形面积
public class Solution65 {
    public static int largestRectangleArea(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int max=0,cur=0,curPos,width,tmp;
        for(int i=0;i<=height.length;i++){
            if(i == height.length){
                cur = -1;
            }else{
                cur =  height[i];
            }
            if(stack.isEmpty() || (i<height.length &&cur>=height[stack.peek()])){
                stack.push(i);
            }else {
                curPos = stack.pop();
                //最关键之处，i是距离curPos最右侧的大于height[i]的位置，stack.peek()是最左侧（不包含，中间的数可能已经被弹出）大于它的位置
                width = stack.isEmpty()?i:i-1-stack.peek();
                tmp = height[curPos]*width;
                max = max>tmp?max:tmp;
                i--;
            }
        }
        return max;
    }

    public static void main(String [] args){
        System.out.println(largestRectangleArea(new int[]{4,2,0,3,2,5}));
    }
}
