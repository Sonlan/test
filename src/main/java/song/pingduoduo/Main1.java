package song.pingduoduo;

import java.util.ArrayList;

/**
 * Created by Song on 2017/8/27.
 */
public class Main1 {
    public static ArrayList<String> process(int [][] matrix){
        ArrayList<String> result = new ArrayList<>();
        if(null == matrix || 0 == matrix.length) return result;
        int m = matrix.length;
        int n = matrix[0].length;
        int index = n-1;
        int max = 0;
        ArrayList<Integer> tmp = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=index;j>=0;j--){
                if(matrix[i][j] == 1) continue;
                index = j;
                if(n-1-index>max){
                    tmp.clear();
                    max = n-1-index;
                    tmp.add(i);
                }else if(n-1-index == max){
                    tmp.add(i);
                }
                break;
            }
        }

        for(int val:tmp){
            result.add("["+val+","+max+"]");
        }
        return result;
    }

    public static void main(String [] args){
         int [][] matrix = new int[][]{
                 {0,0,0,0,0,0,1},
                 {0,0,0,1,1,1,1},
                 {0,0,0,1,1,1,1}
         };
        System.out.println(process(matrix));
    }
}
