package song.questionbank.leetcode_niuke;

import java.util.Stack;

/**
 * Created by Song on 2017/8/9.
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.
 */
public class Solution64 {
    public static int maximalRectangle(char[][] matrix) {
        if(null == matrix || 0 == matrix.length || 0==matrix[0].length) return 0;
        int [][] height = new int[matrix.length][matrix[0].length];
        for(int j = 0;j<matrix[0].length;j++){
            for(int k=0;k<matrix.length;k++) {
                for (int i = k; i < matrix.length; i++) {
                    if (matrix[i][j] == '1') {
                        height[k][j] ++;
                    } else {
                        break;
                    }
                }
            }
        }
        int max=0,tmp;
        for(int i=0;i<height.length;i++){
            tmp = largestRectangleArea(height[i]);
            max = max>tmp?max:tmp;
        }
        return max;
    }

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
           /*char [][] matrix = new char[][]{
                   {'1','0','0','1'},
                   {'1','1','0','1'},
                   {'1','1','1','1'},
                   {'1','1','1','1'},
           };*/
        char [][] matrix = new char[][]{
                {'1'}
        };
        System.out.println(maximalRectangle(matrix));
    }
}
