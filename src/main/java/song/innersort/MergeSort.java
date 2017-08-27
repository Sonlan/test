package song.innersort;

/**
 * Created by Song on 2017/8/27.
 */
public class MergeSort extends Sort{

    @Override
    public void sort(int[] a) {
        mergeSort(a,0,a.length-1);
    }

    private void mergeSort(int [] a,int start,int end){
        if(start>=end) return;
        int mid = (end-start)/2+start;
        mergeSort(a,start,mid);
        mergeSort(a,mid+1,end);
        merge(a,start,mid+1,end);
    }

    public  void merge(int [] a, int start, int center, int end){
        if(start>=end) return;
        int i=start,j=center,index=0;
        int [] tmp = new int[end-start+1];
        while (i<center && j <=end){
            if(a[i]<=a[j]){
                tmp[index++] = a[i++];
            }else {
                tmp[index++] = a[j++];
            }
        }
        while (i<center) tmp[index++] = a[i++];
        while (j<=end) tmp[index++] = a[j++];
        index = 0;
        for(i = start;i<=end;i++){
            a[i] = tmp[index++];
        }
    }

    public void swap(int [] a,int i,int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    public static void main(String [] args){
        int [] a = new int[]{1,3,3,5,2,1,5,6,7};
        MergeSort sort = new MergeSort();
        sort.sort(a);
        sort.print(a);
        System.out.println();
    }

}
