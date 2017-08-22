package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/21.
 * Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 Note:
 You are not suppose to use the library's sort function for this problem.
 click to show follow up.
 Follow up:
 A rather straight forward solution is a two-pass algorithm using counting sort.
 First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
 Could you come up with an one-pass algorithm using only constant space?
 */
//一串 0 1 2 排序 使得 0 .. 0 1 .. 1 2 .. 2，要求一次遍历，用首尾位置变量记录0和2对应插入的位置，这样就分成了三份
public class Solution74 {
    public void sortColors(int[] A) {
        if(null == A || 1>=A.length) return;
        int red=0,blue=A.length-1;
        for(int i=0;i<A.length;i++){
            if(red > blue) break;
            if(A[i] == 0 && i>=red) swap(i--,red++,A);
            else if(A[i]== 2 && i<=blue) swap(i--,blue--,A);
        }
    }

    public void swap(int i,int j,int [] A){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String [] args){
        Solution74 sol = new Solution74();
        sol.sortColors(new int[]{1,0});
    }

}
