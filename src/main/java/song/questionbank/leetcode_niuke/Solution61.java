package song.questionbank.leetcode_niuke;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Song on 2017/8/9.
 * Given two sorted integer arrays A and B, merge B into A as one sorted array.
 Note:
 You may assume that A has enough space to hold additional elements from B.
 The number of elements initialized in A and B are m and n respectively.
 */
//借助队列
public class Solution61 {
    public void merge(int A[], int m, int B[], int n) {
        Queue<Integer> queue = new LinkedList<>();
        int i=0,j=0;
        while (i<m && j<n){
            if(A[i]<B[j]){
                queue.add(A[i++]);
            }else {
                queue.add(B[j++]);
            }
        }
        while (i<m){
            queue.add(A[i++]);
        }
        while (j<n){
            queue.add(B[j++]);
        }
        i=0;
        while (!queue.isEmpty()){
            A[i++] = queue.poll();
        }
    }

    public static void main(String [] args){
        Solution61 sol = new Solution61();
        int [] A = new int[]{1,3,5,7,9};
        int [] B = new int[]{2,4,6,8,10,11,12};
        sol.merge(A,A.length,B,B.length);
        System.out.println();
    }
}
