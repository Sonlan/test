package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/23.
 * Given an integer n, generate a square matrix filled with elements from 1 to n 2 in spiral order.
 For example,
 Given n =3,
 You should return the following matrix:
 [
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
 ]
 */
//挺经典的，注意思路，用对角线起始点与中点坐标标识一个圈
public class Solution91_spiral_matrix_ii {
    public int[][] generateMatrix(int n) {
        int [][] result = new int [n][n];
        int s1=0,e1=0,s2=n-1,e2=n-1;
        int start = 1;
        while (s1<=s2 && e1<=e2){
            start = process(s1++,e1++,s2--,e2--,start,result);
        }
        return result;
    }

    public int process(int s1,int e1,int s2,int e2,int start,int [][] data){
        for(int j = e1;j<=e2;j++){
            data[s1][j] = start++;
        }
        for(int i=s1+1;i<=s2;i++){
            data[i][e2] = start++;
        }
        for(int j=e2-1;j>=e1;j--){
            data[s2][j] = start++;
        }
        for(int i=s2-1;i>s1;i--){
            data[i][e1] =  start++;
        }
        return start;
    }

    public static void main(String [] args){
        Solution91_spiral_matrix_ii sol = new Solution91_spiral_matrix_ii();
        System.out.println(sol.generateMatrix(3));
    }
}
