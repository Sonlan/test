package song.questionbank.tooffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Song on 2017/6/10.
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 */
public class Solution33 {
    public int GetUglyNumber_Solution(int index) {
        List<Integer> list = new ArrayList<Integer>(index);
        list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
        if(index<=0) return 0;
        if(index<5) return list.get(index-1);
        int pos = 5,tmp;
        while ((pos = list.size())<index){
            int min = Integer.MAX_VALUE;
            for(int val:list){
                tmp = val*2;
                if(tmp<min && tmp>list.get(pos-1)) min = tmp;
                tmp = val*3;
                if(tmp<min && tmp>list.get(pos-1)) min = tmp;
                tmp = val*5;
                if(tmp<min && tmp>list.get(pos-1)) min = tmp;
            }
            if(min<Integer.MAX_VALUE) list.add(min);
        }
        return list.get(index-1);
    }

    public static void main(String [] args){
        System.out.println(new Solution33().GetUglyNumber_Solution(6));
    }
}
