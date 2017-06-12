package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/12.
 * 统计一个数字在排序数组中出现的次数。
 * 思路：折半查找,可以试试非递归写法
 */
public class Solution37 {
    public int GetNumberOfK(int [] array , int k) {
        if(null == array || array.length ==0 || k<array[0] || k> array[array.length-1]) return 0;
        return getNumberOfKCore(array,k,0,array.length-1);
    }

    private int getNumberOfKCore(int [] array,int k,int start,int end){
        if(start>end) return 0;
        if(start == end) if(array[start] == k) return 1;
        int mid = (end-start)>>1;
        int count = 0;
        if(array[start+mid]==k){
            int i=start+mid-1;
            while ((++i)<=end){
                if(array[i] == k){
                    count++;
                    continue;
                }
                break;
            }
            i = start+mid;
            while ((--i)>=start){
                if(array[i] == k){
                    count++;
                    continue;
                }
                break;
            }
            return count;
        }else if(array[mid]>k){
            return getNumberOfKCore(array, k, start, start+mid-1);
        }else return getNumberOfKCore(array, k, start+mid+1, end);
    }

    public static void main(String [] args){
        System.out.println(new Solution37().GetNumberOfK(new int[]{1,2,3,3,3,3,4,5},3));
    }
}
