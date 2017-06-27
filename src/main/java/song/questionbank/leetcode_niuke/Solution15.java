package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/27.
 * Given an array of integers, every element appears twice except for one. Find that single one.
 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution15 {
    public int singleNumber(int[] A) {
        int tmp=A[0];
        for(int i=1;i<A.length;i++){
            tmp ^= A[i];
        }
        return tmp;
    }

    public static void main(String [] args){
        Solution15 sol = new Solution15();
        System.out.println(sol.singleNumber(new int[]{1,1,2,3,3}));
    }
}
