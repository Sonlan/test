package song.innersort;

/**
 * Created by Administrator on 2017/2/27.
 */
public class Sort {

    public void quicksort(int [] a,int left,int right){
        if(right-left>2){
            int pivot = media3(a,left,right);
            int i=left,j=right;
            for(;i<=right&&j>=left;){
                while (a[++i]<pivot){}
                while (a[--j]>pivot){j--;}
                if(i<j){
                    swap(a,i,j);
                }else {
                    break;
                }
            }
            swap(a,i,right);
            print(a);
            quicksort(a,left,i-1);
            quicksort(a,i+1,right);
        }else if(right-left == 2){
            print(a);
            media3(a,left,right);
        }else if(right -left == 1){
            print(a);
            if(a[right]<a[left])
                swap(a,left,right);
        }
    }

    private int media3(int []a, int left,int right){
        int center = (left+right)/2;
        if(a[right]<a[center])
            swap(a,center,right);
        if(a[center]<a[right])
            swap(a,center,left);
        if(a[right]<a[left])
            swap(a,left,right);
        swap(a,center,right);
        print(a);
        return a[right];
    }

    private void swap(int [] a,int index1,int index2){
        int temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static void main(String [] args){
        int [] a = {5,4,6,9,2,1,7,8,3,12,1,15};
        Sort sort = new Sort();
        print(a);
        sort.quicksort(a,0,a.length-1);
        print(a);
        System.out.println();
    }

    public static void print(int [] a){
        for (int i=0;i<a.length;i++){
            System.out.printf("%d\t",a[i]);
        }
        System.out.println();
    }
}
