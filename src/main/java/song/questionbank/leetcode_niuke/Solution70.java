package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/16.
 * Given a 2D board and a word, find if the word exists in the grid.
 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 For example,
 Given board =
 [
 ["ABCE"],
 ["SFCS"],
 ["ADEE"]
 ]
 word ="ABCCED", -> returnstrue,
 word ="SEE", -> returnstrue,
 word ="ABCB", -> returnsfalse.
 */
public class Solution70 {
    public boolean exist(char[][] board, String word) {
        boolean [][] flag = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(existCore(board,word,0,flag,i,j))
                    return true;
            }
        }
        return false;
    }

    public boolean existCore(char [][] board,String word,int len,boolean [][] flag,int i,int j) {
        if (len >= word.length()) return true;
        if(i<0 || i>=board.length || j<0 || j>=board[0].length) return false;
        if(flag[i][j]) return false;
        flag[i][j] = true;
        if (board[i][j] == word.charAt(len)) {
            if (existCore(board, word, len+1, flag, i + 1, j)
                    || existCore(board, word, len+1, flag, i, j + 1)
                    || existCore(board, word, len+1, flag, i - 1, j)
                    || existCore(board, word, len+1, flag, i, j - 1)) {
                return true;
            }
        }
        flag[i][j] = false;
        return false;
    }

    public static void main(String [] args){
        char [][] board = new char[][]{
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        Solution70 sol = new Solution70();
        System.out.println(sol.exist(board,"SEE"));
    }
}
