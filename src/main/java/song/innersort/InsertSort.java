package song.innersort;

/**
 * Created by Song on 2017/3/15.
 */
public class InsertSort extends Sort{

    public void sort(int [] a){
        for(int i=1;i<a.length;i++){
            int temp = a[i];
            int j = i;
            for(j=i;j>0;j--){
                if(temp<a[j-1]){
                    a[j] = a[j-1];
                }else {
                    break;
                }
            }
            a[j] = temp;
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
