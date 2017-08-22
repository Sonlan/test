package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/21.
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

 Integers in each row are sorted from left to right.
 The first integer of each row is greater than the last integer of the previous row.

 For example,
 Consider the following matrix:
 [
 [1,   3,  5,  7],
 [10, 11, 16, 20],
 [23, 30, 34, 50]
 ]
 Given target =3, returntrue.
 */
public class Solution75 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(null == matrix || 0==matrix.length || 0==matrix[0].length) return false;
        int n = matrix[0].length;
        for(int i=0;i<matrix.length;i++){
            if(target<matrix[i][0]) return false;
            if(target>matrix[i][n-1]) continue;
            return findCore(matrix[i],0,n-1,target);
        }
        return false;
    }
    //折半查找
    public boolean findCore(int [] data, int start,int end,int target){
        if(start>end) return false;
        if(target == data[start] || target == data[end]) return true;
        int mid = (end + start)/2;
        if(target == mid) return true;
        if(target < mid) return findCore(data,start+1,mid-1,target);
        else return findCore(data, mid=1, end-1, target);
    }
}
