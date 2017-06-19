package song.questionbank.tooffer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Song on 2017/6/19.
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class Solution63 {
    private List<Integer> source = new LinkedList<Integer>();

    public void Insert(Integer num) {
        if(source.size()==0) {
            source.add(num);
            return;
        }
        source.add(num);
        for(int i=source.size()-2;i>=0;i--){
            if(source.get(i)>num){
                swap(source,i,i+1);
            }else break;
        }
    }

    private void swap(List<Integer> list ,int i,int j){
        int temp = list.get(i);
        list.set(i,list.get(j));
        list.set(j,temp);
    }

    public Double GetMedian() {
        int size = source.size();
        if(size%2 == 0){
            return (source.get(size/2-1)+source.get(size/2))/2.0;
        }else return (double)source.get(size/2);
    }

    public static void main(String [] args){
        Solution63 sol = new Solution63();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            sol.Insert(scanner.nextInt());
            System.out.println(sol.GetMedian());
        }
    }
}
