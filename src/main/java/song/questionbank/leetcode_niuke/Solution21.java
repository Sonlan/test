package song.questionbank.leetcode_niuke;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Song on 2017/7/5.
 * Given a 2D board containing'X'and'O', capture all regions surrounded by'X'.
 A region is captured by flipping all'O's into'X's in that surrounded region .
 For example,
 X X X X
 X O O X
 X X O X
 X O X X

 After running your function, the board should be:
 X X X X
 X X X X
 X X X X
 X O X X
 */
public class Solution21 {
    public void solve(char[][] board) {
        if(null == board || board.length==0 || board[0].length ==0) return;
        Set<Integer> set = new HashSet<Integer>();
        int height = board.length;
        int width = board[0].length;
        boolean [][] flag = new boolean[height][width];

        for(int j=0;j<width;j++){
            if(board[0][j]=='O') dfs(board,flag,0,j,set);
            if(board[height-1][j]=='O') dfs(board,flag,height-1,j,set);
        }
        for(int i=0;i<height;i++){
            if(board[i][width-1]=='O') dfs(board,flag,i,width-1,set);
            if(board[i][0]=='O') dfs(board,flag,i,0,set);
        }
        for(int i=0;i<height;i++){
            for(int j=0;j<width;j++){
                if(set.contains(i*width+j) || board[i][j]!='O') continue;
                board[i][j] = 'X';
            }
        }
    }

    private void dfs(char [][] board,boolean [][] flag, int i, int j, Set<Integer> set){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length) return;
        if(!flag[i][j] && board[i][j] == 'O'){
            flag[i][j] = true;
            set.add(i*board[0].length+j);
            dfs(board, flag, i-1, j, set);
            dfs(board, flag, i+1, j, set);
            dfs(board, flag, i, j-1, set);
            dfs(board, flag, i, j+1, set);
        }
    }
    public static void main(String [] args){
        char [][] board = new char[][]{
                {'X','X','X','X'},
                {'X','O','O','X'},
                {'X','X','O','X'},
                {'X','O','X','X'}
        };
        Solution21 sol = new Solution21();
        sol.solve(board);
        System.out.println(board);
    }
}
