package song.innersort;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Song on 2017/3/16.
 * 希尔排序
 */
public class ShellSort extends Sort {
    @Override
    public void sort(int[] a) {
        if(null == a || 1>=a.length) return;
        int j,curPos;
        //本应传入增量序列，这里简化为采用Shell序列
        for(int gap = a.length/2;gap>0;gap /=2){
            //对增量为gap的所有子序列进行插入排序,这里是书上的一种实现方式
            //起点为i,增量为gap的所有子序列，其实就是包括所有增量为gap的子序列
            //当然也可以起点从0开始，采用gap递增的方式对所有子序列进行排序
            for(int i=gap;i<a.length;i++){
                curPos = a[i];
                for(j=i;j>gap-1 && curPos<a[j-gap];j-=gap){
                    a[j] = a[j-gap];
                }
                a[j] = curPos;
            }
        }
    }

    public static void main(String [] args){
        int [] a = new int[]{9,8,7,6,5,4,3,2,1};
        Sort sort = new ShellSort();
        sort.sort(a);
        sort.print(a);
        List<String> list = new ArrayList<String>();
        list.add("asd");
        list.add("asdds");
        list.add("werdf");
        System.out.println(list.toString());
    }
}
