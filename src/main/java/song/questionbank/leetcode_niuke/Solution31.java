package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/7/23.
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 For example, given the following triangle
 [
 [2],
 [3,4],
 [6,5,7],
 [4,1,8,3]
 ]

 The minimum path sum from top to bottom is11(i.e., 2 + 3 + 5 + 1 = 11).
 Note:
 Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 */
public class Solution31 {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        if(null == triangle || 0== triangle.size()) return 0;
        ArrayList<ArrayList<Integer>> process = new ArrayList<ArrayList<Integer>>();
        int arg1,arg2;
        for(int i=0;i<triangle.size();i++){
            ArrayList<Integer> row = triangle.get(i);
            if(0==i) {
                process.add(row);continue;
            }
            ArrayList<Integer> newRow = new ArrayList<Integer>(row.size());
            for(int j=0;j<row.size();j++){
                newRow.add(findMin(process.get(i-1),j)+row.get(j));
            }
            process.add(newRow);
        }
        return findMin2(process.get(process.size()-1));
    }


    private int findMin(ArrayList<Integer> data,int index){
        if(null == data || 0== data.size() || index<0) return 0;
        int arg1,arg2;
        if(index-1>=0)
            arg1 = data.get(index-1);
        else arg1 = Integer.MAX_VALUE;
        if(index<=data.size()-1)
            arg2 = data.get(index);
        else arg2 = Integer.MAX_VALUE;
        return arg1<arg2?arg1:arg2;
    }
    private int findMin2(ArrayList<Integer> data){
        if(null == data || 0== data.size()) return 0;
        int min = data.get(0);
        for(int val:data){
            if(val<min) min = val;
        }
        return min;
    }
}
