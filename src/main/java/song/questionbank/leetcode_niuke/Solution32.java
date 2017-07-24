package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/7/23.
 * Given an index k, return the k th row of the Pascal's triangle.
 For example, given k = 3,
 Return[1,3,3,1].
 Note:
 Could you optimize your algorithm to use only O(k) extra space?
 */
public class Solution32 {
    public ArrayList<Integer> getRow(int rowIndex) {
        ArrayList<ArrayList<Integer>> process = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> first = new ArrayList<Integer>();
        if(rowIndex<0) return first;
        first.add(1);
        if(rowIndex==0) return first;
        process.add(first);
        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(1);second.add(1);
        if(rowIndex == 1) return second;
        process.add(second);
        for(int i=2;i<=rowIndex;i++){
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            ArrayList<Integer> lastRow = process.get(i-1);
            for(int j=0;j<lastRow.size();j++){
                if(j==0) {
                    newRow.add(1);continue;
                }
                newRow.add(lastRow.get(j-1)+lastRow.get(j));
            }
            newRow.add(1);
            if (i==rowIndex) return newRow;
            process.add(newRow);
        }
        return process.get(rowIndex);
    }
}
