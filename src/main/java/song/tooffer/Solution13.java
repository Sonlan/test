package song.tooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/3/7.
 * 调整数组使奇数在偶数前
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 解题思路（s）：采用冒泡的思想，偶数较轻，奇数较重，一个上浮一个下沉，遇到同类则粘连在一起（保证相对位置）运动。
 */
public class Solution13 {
    public void reOrderArray(int [] array) {
        int start = -1;
        for(int i=0;i<array.length;i++){
            if(array[i]%2!=0){
                if(start < 0) continue;
                swap(start,array,i);
                start += 1;
            }
            else{
                if(0>start) start = i;
            }
        }
    }

    private void swap(int start,int [] array,int target){
        int temp = array[target];
        for(int i=target;i>start;i--){
            array[i]=array[i-1];
        }
        array[start] = temp;
    }

    void print(int [] array){
        for(int val:array){
            System.out.printf("%d\t",val);
        }
        System.out.println();
    }

    public static void main(String [] args){
      Solution13 solution13 = new Solution13();
      int [] array = new int[]{1,2,4,3,6,7,9,4};
      solution13.reOrderArray(array);
      solution13.print(array);
    }
}
