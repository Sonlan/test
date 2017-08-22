package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/16.
 * Follow up for "Remove Duplicates":
 What if duplicates are allowed at most twice?
 For example,
 Given sorted array A =[1,1,1,2,2,3],
 Your function should return length =5, and A is now[1,1,2,2,3].
 */
public class Solution69 {
    public static int removeDuplicates(int[] A) {
        if(null == A) return 0;
        if(A.length<3) return A.length;
        int index =0,i=0,count=0;
        while (i<A.length){
            while (i+1 < A.length && A[i+1] == A[i]){
                count++;
                if(count<=2){
                    A[index++] = A[i];
                }
                i++;
            }
            if(count<2) {
                A[index++] = A[i++];
            }else i++;
            count = 0;
        }
        return index;
    }

    public static void main(String [] args){
        System.out.println(removeDuplicates(new int[]{1,1,1,2,2,2,3,3,4,5}));
    }
}
