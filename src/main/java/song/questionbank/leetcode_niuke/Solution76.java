package song.questionbank.leetcode_niuke;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Song on 2017/8/21.
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
 click to show follow up.
 Follow up:
 Did you use extra space?
 A straight forward solution using O(m n) space is probably a bad idea.
 A simple improvement uses O(m + n) space, but still not the best solution.
 Could you devise a constant space solution?
 */
public class Solution76 {
    public void setZeroes(int[][] matrix) {
        if(null == matrix || 0 == matrix.length || 0 == matrix[0].length) return;
        Set<Integer> cols = new HashSet<>();
        Set<Integer> rows = new HashSet<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        setZeroCore(matrix,rows,cols);
    }

    public void setZeroCore(int [][] matrix,Set<Integer> rows,Set<Integer> cols){
        for(int val:rows){
            for(int k=0;k<matrix[0].length;k++){
                matrix[val][k] = 0;
            }
        }
        for(int val:cols){
            for(int k=0;k<matrix.length;k++){
                matrix[k][val] = 0;
            }
        }
    }

    public static void main(String [] args){
        Solution76 sol = new Solution76();
        sol.setZeroes(new int[][]{{0}});
    }
}
