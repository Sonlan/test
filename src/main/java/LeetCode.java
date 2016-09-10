import java.util.ArrayList;

/**
 * Created by Song on 2016/7/29.
 */
public class LeetCode {
    private static int value = 2;

    public static void main(String [] args){
        int [] nums1 = {1,4,6,9};
        int [] nums2 = {2,6,10,11};
        LeetCode lc = new LeetCode();
        System.out.println(lc.findMedianSortedArrays(nums1,nums2));
 //       System.out.println(guessNumber(2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        ArrayList<Integer> res = new ArrayList<Integer>();

        if(0==(len1+len2)%2) return (res.get((len1+len2)/2-1)+res.get((len1+len2)/2+1))/2.0;
        else return res.get((len1+len2)/2+1);
    }

}
