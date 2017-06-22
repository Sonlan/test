package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/19.
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bcced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 */
public class Solution65 {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        char [][] m = new char[rows][cols];
        boolean [][] flag = new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                m[i][j] = matrix[i*cols+j];
                flag[i][j] = false;
            }
        }
        for(int i=0;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                System.out.println("**************************");
                if(findPath(m,i,j,0,str,flag))
                    return true;
            }
        }
        return false;
    }

    public boolean findPath(char [][] m,int row,int col,int len,char [] str,boolean [][] flag){
        if(len>= str.length) return true;
        if(col>=m[0].length || row>=m.length || col<0 || row<0 ) return false;

        if(flag[row][col] == true) return false;

        if(m[row][col] != str[len]) return false;

        flag[row][col] = true;
        System.out.println(m[row][col]);
        if(findPath(m,row,col+1,len+1,str,flag)||
                findPath(m, row, col-1, len+1, str,flag)||
                findPath(m, row+1, col, len+1, str,flag)||
                findPath(m, row-1, col, len+1, str,flag))
            return true;
        flag[row][col] = false;
        return false;
    }
/*
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        int flag[] = new int[matrix.length];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (helper(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }

    private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag) {
        int index = i * cols + j;
        if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length - 1) return true;
        flag[index] = 1;
        if (helper(matrix, rows, cols, i - 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i + 1, j, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j - 1, str, k + 1, flag)
                || helper(matrix, rows, cols, i, j + 1, str, k + 1, flag)) {
            return true;
        }
        flag[index] = 0;
        return false;
    }
*/


    public static void main(String [] args){
        Solution65 sol = new Solution65();
        /*System.out.println(sol.hasPath(new char[]{'a','a','a','a','a','a','a','a','a','a','a','a'},3,4,new char[]{'a','a','a','a','a','a','a','a','a','a','a','a'}));
        System.out.println(sol.hasPath(new char[]{'a','b','c','d','e','f','g','h','i','j','k','l'},4,3,new char[]{'a','b','a'}));
        */System.out.println(sol.hasPath("ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray(),5,8,"SGGFIECVAASABCEHJIGQEM".toCharArray()));
    }
}
