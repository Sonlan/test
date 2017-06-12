package song.questionbank.tooffer;

import java.util.Scanner;

/**
 * Created by Song on 2017/6/9.
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution28 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length==0) return 0;
        int temp = array[0];
        int count = 0;
        for(int i=0;i<array.length;i++){
            if(count<=0) {
                count = 0;
                temp = array[i];
            }
            if(temp == array[i]) count++;
            else if(temp != array[i]) count--;
        }
        if(count>0) {
            count = 0;
            for(int i=0;i<array.length;i++){
                if(temp == array[i]) count++;
            }
        }
        if(count>array.length/2) return temp;
        else return 0;
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String source = scanner.nextLine();
        String [] array = source.split(",");
        int [] aa = new int[array.length];
        for(int i=0;i<array.length;i++){
            aa[i] = Integer.parseInt(array[i]);
        }
        System.out.println(new Solution28().MoreThanHalfNum_Solution(aa));
    }
}
