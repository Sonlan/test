package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/7/24.
 * Given numRows, generate the first numRows of Pascal's triangle.
 For example, given numRows = 5,
 Return
 [
 [1],
 [1,1],
 [1,2,1],
 [1,3,3,1],
 [1,4,6,4,1]
 ]
 */
public class Solution33 {
    public ArrayList<ArrayList<Integer>> generate(int numRows) {
        ArrayList<ArrayList<Integer>> process = new ArrayList<ArrayList<Integer>>();
        if(0>=numRows) return process;
        ArrayList<Integer> first = new ArrayList<Integer>();
        first.add(1);
        process.add(first);
        if(1 == numRows) return process;
        ArrayList<Integer> second = new ArrayList<Integer>();
        second.add(1);second.add(1);
        process.add(second);
        if(2 == numRows) return process;
        for(int i=2;i<numRows;i++){
            ArrayList<Integer> newRow = new ArrayList<Integer>();
            ArrayList<Integer> lastRow = process.get(i-1);
            for(int j=0;j<lastRow.size();j++){
                if(j==0) {
                    newRow.add(1);continue;
                }
                newRow.add(lastRow.get(j-1)+lastRow.get(j));
            }
            newRow.add(1);
            process.add(newRow);
        }
        return process;
    }
}
