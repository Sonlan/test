package song.questionbank.tooffer;

import java.util.ArrayList;

/**
 * Created by Song on 2017/3/8.
 * 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 解题思路：用左上和右下两个点表示一个矩阵，封装一个函数打印外围。然后依次收缩矩阵，直到两个顶点交叉错过
 * 注意：后两个while的判断条件，考虑只有一维的时候，避免重复打印
 */
public class Solution19 {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        int x_max = matrix.length-1;
        int y_max = matrix[0].length-1;
        int i=0,j=0;
        ArrayList<Integer> res = new ArrayList<Integer>();
        while (i<=x_max && j<=y_max){
            res = printSingleMatrix(matrix,i,j,x_max,y_max,res);
            i++;j++;
            x_max--;y_max--;
        }
        return res;
    }

    /**
     *
     * @param x1 左上角 横坐标
     * @param y1 左上角 纵坐标
     * @param x2 右下角 横坐标
     * @param y2 右下角 纵坐标
     * @param res 结果列表
     * @return
     */
    private ArrayList<Integer> printSingleMatrix(int [][] matrix,int x1,int y1,int x2,int y2,ArrayList<Integer> res){
        int i=x1,j=y1;
        while (j<=y2) {
            res.add(matrix[x1][j]);
            j++;
        }
        i=x1+1;
        while (i<=x2){
            res.add(matrix[i][y2]);
            i++;
        }
        if(x2 != x1) {
            j = y2 - 1;
            while (j >= y1) {
                res.add(matrix[x2][j]);
                j--;
            }
        }
        if(y1 != y2) {
            i = x2 - 1;
            while (i > x1) {
                res.add(matrix[i][y1]);
                i--;
            }
        }
        return res;
    }

    public static void main(String [] args){
        Solution19 solution19 = new Solution19();
        int [][] matrix = new int[][]{{1,2},{3,4}};
        ArrayList<Integer> res = solution19.printMatrix(matrix);
        System.out.println(res);
    }
}
