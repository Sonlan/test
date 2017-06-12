package song.questionbank.tooffer;

import java.util.ArrayList;

/**
 * Created by Song on 2017/6/9.
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,
 */
public class Solution29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(k>input.length) return list;

        int index;
        for(int i=0;i<k;i++){
            index = i;
            for(int j=i+1;j<input.length;j++){
                if(input[j]<input[index])
                    index = j;
            }
            swap(input,i,index);
            list.add(input[i]);
        }
        return list;
    }

    private void swap(int [] input,int i,int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}
