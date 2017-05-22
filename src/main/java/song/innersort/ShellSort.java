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
        int j;
        for(int gap = a.length/2;gap>0;gap = gap/2){
            for(int i=gap;i<a.length;i++){
                int temp = a[i];
                for(j=i;j>=gap && temp<a[j-gap];j-=gap)
                    a[j] = a[j-gap];
                a[j] = temp;
            }
        }
    }

    public static void main(String [] args){
        /*int [] a = new int[]{9,8,7,6,5,4,3,2,1};
        Sort sort = new ShellSort();
        sort.sort(a);
        sort.print(a);*/
        List<String> list = new ArrayList<String>();
        list.add("asd");
        list.add("asdds");
        list.add("werdf");
        System.out.println(list.toString());
    }
}
