package song.questionbank.tooffer;

import java.util.*;

/**
 * Created by Song on 2017/6/10.
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323
 */
public class Solution32 {
    public String PrintMinNumber(int [] numbers) {
        List<Integer> list = new ArrayList<Integer>(numbers.length);
        for(int val:numbers){
            list.add(val);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if(Integer.parseInt(o1+""+o2)>Integer.parseInt(o2+""+o1))
                    return 1;
                else if(Integer.parseInt(o1+""+o2)<Integer.parseInt(o2+""+o1))
                    return -1;
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int val:list){
            sb.append(val);
        }
        return sb.toString();
    }
    //排序，排序规则{3，,32} 332>323  ->  {32,3}

    public static void main(String [] args){
        System.out.println(new Solution32().PrintMinNumber(new int[]{3,32,321}));
    }
}
