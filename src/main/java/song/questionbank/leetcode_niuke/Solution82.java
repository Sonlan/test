package song.questionbank.leetcode_niuke;

import java.util.ArrayList;

/**
 * Created by Song on 2017/8/22.
 * Given a number represented as an array of digits, plus one to the number.
 */
//用一个数组代表一个数，返回该数加一的结果
public class Solution82 {
    public int[] plusOne(int[] digits) {
        int flag=0; //进位标志
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = digits.length-1;i>=0;i--){
            if(i == digits.length-1) {
                if (digits[i] == 9) {
                    list.add(0);
                    flag = 1;
                } else list.add(digits[i] + 1);
            }else {
                int tmp = digits[i]+flag;
                if(tmp>9){
                    list.add(tmp%10);
                    flag = 1;
                }else {
                    list.add(tmp);flag = 0;
                }
            }
        }
        if(flag == 1) list.add(1);
        int [] result = new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i] = list.get(list.size()-1-i);
        }
        return result;
    }
}
