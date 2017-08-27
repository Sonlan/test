package song.innersort;

/**
 * Created by Song on 2017/8/27.
 */
public class QuickSort extends Sort {
    @Override
    public void sort(int[] a) {
        if(null == a || 0 == a.length) return;
        quickSort(a,0,a.length-1);
        print(a);
    }

    private void quickSort(int [] a,int begin,int end){
        if(begin >= end) return;
        int i = begin,j=end+1;
        while (i<j){
            while (i<end && a[++i]<a[begin]){}
            while (a[--j]>a[begin]){}
            if(i<j) {
                swap(a, i, j);
            }else break;
        }
        swap(a,begin,j);
        quickSort(a,begin,j-1);
        quickSort(a,j+1,end);
    }

    private void swap(int [] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String [] args){
        QuickSort quickSort = new QuickSort();
        int [] a = new int[]{3,2,1};
        quickSort.sort(a);
        System.out.println(a);
    }


}
