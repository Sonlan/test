package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/22.
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
 * 每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。
 * 但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 */
public class Solution66 {
    public int movingCount(int threshold, int rows, int cols) {
        boolean [][] isUsed = new boolean[rows][cols];
        return movingCountCore(threshold,rows,cols,0,0,isUsed);
    }

    private int movingCountCore(int threshold,int rows,int cols,int i,int j,boolean [][] isUsed){
        if(i<0 || j<0 || i>=rows || j>=cols || add(i,j)>threshold || isUsed[i][j] == true) return 0;
        isUsed[i][j] = true;
        System.out.println("("+i+","+j+")");
        return 1+
                movingCountCore(threshold, rows, cols, i, j+1,isUsed)+
                movingCountCore(threshold, rows, cols, i, j-1,isUsed)+
                movingCountCore(threshold, rows, cols, i+1, j,isUsed)+
                movingCountCore(threshold, rows, cols, i-1, j,isUsed)
        ;
    }

    private int max(int ... nums){
        if(nums.length<=0) return -1;
        int max = nums[0];
        for(int val:nums){
            if(val >max)
                max = val;
        }
        return max;
    }

    private int add(int i,int j){
        String str1 = i+"";
        String str2 = j+"";
        int sum = 0;
        for(char c:str1.toCharArray()){
            sum+=Integer.parseInt(c+"");
        }
        for(char c:str2.toCharArray()){
            sum+=Integer.parseInt(c+"");
        }
        return sum;
    }

    public static void main(String [] args){
        Solution66 sol = new Solution66();
        System.out.println(sol.movingCount(5,10,10));
    }
}
