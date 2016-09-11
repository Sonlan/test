import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Song on 2016/7/29.
 */
public class LeetCode {
    private static int value = 2;

    public static void main(String [] args){
        int [] nums1 = {100001};
        int [] nums2 = {};
        LeetCode lc = new LeetCode();
        System.out.println(lc.findMedianSortedArrays(nums1,nums2));
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int temp2=0;  //记录nums2中的上次插入位置
        ArrayList<Integer> res = new ArrayList<Integer>();
        //将nums1向nums2中插入
        for(int i=0;i<len1;i++){
            for(int j=temp2;j<len2;j++){
                if(nums1[i]<nums2[j]) {
                    res.add(nums1[i]);
                    temp2=j;
                    break;
                }else{
                    res.add(nums2[j]);
                    if(j>=len2-1) {
                        temp2 = len2;
                    }
                }
            }
            if(temp2>=len2){
                res.add(nums1[i]);
            }
        }
        if(temp2<len2){//nums2中还有元素未被插入
            for(int i=temp2;i<len2;i++){
                res.add(nums2[i]);
            }
        }
        if(0==(len1+len2)%2)
            return (res.get((len1+len2)/2-1)+res.get((len1+len2)/2))/2.0;
        else
            return res.get((len1+len2)/2);
    }

}
