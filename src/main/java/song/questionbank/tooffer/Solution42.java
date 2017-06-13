package song.questionbank.tooffer;

import java.util.ArrayList;

/**
 * Created by Song on 2017/6/13.
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * 思路：左右夹逼，距离越远，乘积越小，故第一次匹配的就是最小的
 */
public class Solution42 {
    public ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        if(null == array || 0>=array.length) return result;
        int i=0,j=array.length-1;
        int tempSum = 0;
        while (i<j){
            tempSum = array[i]+array[j];
            if(tempSum==sum){
                result.add(array[i]);
                result.add(array[j]);
                break;
            }else if(tempSum<sum){
                i++;
            }else{
                j--;
            }
        }
        return result;
    }
}
