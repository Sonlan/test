package song.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Song on 2016/11/17.
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 给定n个非零数，代表垂直坐标轴的一条线段的高度，横坐标为数组下标,任选两条线段，比之为容器，看怎么样水能装得最多
 */
public class Solution11 {
    //方案1：数组过大，超时
/*    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;
        if(length<2) return 0;

        for(int i=0;i<length-1;i++){
            for(int j=i+1;j<length;j++){
                int min = height[i]<=height[j]?height[i]:height[j];
                if(maxArea<(min*(j-i)))
                    maxArea = (min*(j-i));
            }
        }
        return maxArea;
    }*/

    //方案2基于1改进：（1）每次i遍历，必然是首尾围成的最大，故而一次内循环缩成一次计算
    //（2）选择第一步中较大的一个数，到另一端（排除上一次的端点），计算面积，如此反复，取最大值，仅需length次计算
    public int maxArea(int[] height) {
        int length = height.length;
        int maxArea = 0;
        if(length<2) return 0;
        int left = 0,right = length-1;
        while (left<right){
            int minHeight = height[left]<=height[right]?height[left]:height[right];
            int tempArea = (right-left)*minHeight;
            if(maxArea<tempArea)
                maxArea = tempArea;
            if(0==compare(height,left,right)) left++;
            else right--;
        }
        return maxArea;
    }

    int compare(int [] height,int left,int right){
        if(left>=right) return 0;
        if(height[left]<height[right]) return 0;
        else if(height[left]>height[right]) return 1;
        else return compare(height,left+1,right-1);
    }

    //基于改进则减少compare内部重复比较的次数
    public static void main(String [] args){
        int[] height = {2,1};
        System.out.println(new Solution11().maxArea(height));
    }



}
