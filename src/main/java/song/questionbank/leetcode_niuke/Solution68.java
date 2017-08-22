package song.questionbank.leetcode_niuke;

/**
 * Created by Song on 2017/8/16.
 * Follow up for "Search in Rotated Sorted Array":
 What if duplicates are allowed?
 Would this affect the run-time complexity? How and why?
 Write a function to determine if a given target is in the array.
 */
//旋转有序数组 5 6 7 0 1 1 1 2 3 4 5
    //基于二分法，若一点比其最右侧的值大，则其左侧升序，若比最右侧小，则右侧升序
public class Solution68 {
/*    public boolean search(int[] A, int target) {
        if(null == A) return false;
        for(int val:A){
            if(val == target) return true;
        }
        return false;
    }*/
    //二分查找
    public static boolean search(int[] A, int target) {
        if(null == A || 0==A.length) return false;
        int left = 0, right = A.length-1,mid;
        while (left<=right){
            mid = (left+right)/2;
            if(target == A[mid]) return true;

            if(A[mid] == A[right]){
                while (right>mid && A[mid] == A[right]){
                    right--;
                }
            }
            if(A[mid] == A[left]){
                while (left<mid && A[mid] == A[left]){
                    left++;
                }
            }
            if(left>= mid) {
                left = mid+1;
            }else if(right <= mid){
                right = mid -1;
            }else if(A[mid] < A[right]){
                if(target==A[right]) return true;
                if(target > A[right] || target<A[mid]){
                    right = mid-1;
                }else {
                    left = mid+1;
                }
            }else {
                if(target == A[left]) return true;
                if(target < A[left] || target > A[mid]) {
                    left = mid+1;
                }else {
                    right = mid -1;
                }
            }
        }
        return false;
    }
    public static void main(String [] args){
        System.out.println(search(new int[]{1,1,3,1},3));
    }
}
