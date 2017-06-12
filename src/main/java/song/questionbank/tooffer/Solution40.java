package song.questionbank.tooffer;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Song on 2017/6/12.
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 解析推荐：异或操作
 */
public class Solution40 {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    /*public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Set<Integer> numSet = new HashSet<Integer>();
        for(int val:array){
            if(numSet.contains(val))
                numSet.remove(val);
            else numSet.add(val);
        }
        if(numSet.size()==2){
            Iterator<Integer> iterator = numSet.iterator();
            num1[0] = iterator.next();
            num2[0] = iterator.next();
        }
    }*/

    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(null == array || 0>=array.length) return;
        //求解整体异或值
        int temp = array[0];
        for(int i=1;i<array.length;i++){
            temp^=array[i];
        }
        //求取异或值第一位不为0的位置
        int index = 0;
        while (temp!=0){
            if((temp&0x01)!=0) break;
            index++;
            temp = temp>>>1;
        }
        //根据上述位置，将所有数据分为两部分，每部分包括一个数，因为temp结果肯定为两个不同的数异或得到的
        for(int i=0;i<array.length;i++){
            if((array[i]&(0x01<<index))!=0){
                num1[0]^=array[i];
            }else {
                num2[0]^=array[i];
            }
        }

    }
}
