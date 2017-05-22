package song.innersort;

/**
 * Created by Song on 2017/3/15.
 */
public abstract class Sort {
    public void print(int [] a){
        for(int val:a){
            System.out.printf("%d\t",val);
        }
        System.out.println();
    }

    public abstract void sort(int [] a);
}
