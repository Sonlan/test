package song.innersort;

/**
 * Created by Song on 2017/3/15.
 */
public class InsertSort extends Sort{

    public void sort(int [] a){
        if(null == a || 1>=a.length) return;
        int curPos,j;
        for(int i=1;i<a.length;i++){
            curPos = a[i];
            for(j = i;j>0 && curPos < a[j-1];j--){
                a[j] = a[j-1];
            }
            a[j] = curPos;
        }
    }

    public static void main(String [] args){
        int [] a = new int[]{9,8,7,6,5,4,3,2,1};
        Sort sort = new InsertSort();
        sort.sort(a);
        sort.print(a);
        String id = "420982199311061245";
        id.replaceAll("(\\S{8})$","********");
        System.out.println(id);
    }
}
