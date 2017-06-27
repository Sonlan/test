package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/6/27.
 * Given an array of integers, every element appears three times except for one. Find that single one.
 Note:
 Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class Solution14 {
    public int singleNumber(int[] A) {
        if(A.length==1) return A[0];
        int result=0;
        for(int i=0;i<32;i++){
            int bit = 0;
            for(int j=0;j<A.length;j++){
                bit += ((A[j]>>i)&0x1);
            }
            result |= ((bit%3)<<i);
        }
        return result;
    }

    public static void main(String [] args){
        Solution14 sol = new Solution14();
        System.out.println(sol.singleNumber(new int[]{1,1,1,2}));
    }
}
