package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/2/24.
 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数
 */
public class Solution1 {
    public boolean Find(int target, int [][] array) {
        int row = array.length;
        int [] cols = new int[row];
        for(int i=0;i<row;i++){
            cols[i] = array[i].length;
        }
        try{
            if(target<array[0][0] || target>array[row-1][cols[row-1]-1]) return false;
            int j=0;
            for(int i=0;i<row;i++){
                for(j=0;j<cols[i];j++){
                    if(target == array[i][j]) return true;
                    else if(target<array[i][j]){
                        break;
                    }
                }
            }
        }catch (Exception e){
            return false;
        }
        return false;
    }

    public static void main(String [] args){
        Solution1 solution1 = new Solution1();
        //7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
        int [][] array = new int[][]{{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};
        System.out.println(solution1.Find(7,array));
    }
}
