package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/7.
 * 二进制中1的个数
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示
 */
public class Solution11 {
    //法1
    /*public int NumberOf1(int n) {
        String str = Integer.toBinaryString(n);
        int res = 0;
        for(char c:str.toCharArray()){
            if(c!='0') res+=1;
        }
        return  res;
    }*/
    public int NumberOf1(int n) {
        int res = 0;
        int temp = 0;
        for(int i=0;i<32;i++){
            temp=n>>i;
            res+=temp&0x01;
        }
        return  res;
    }
    public static void main(String [] args){
        Solution11 solution11 = new Solution11();
        solution11.NumberOf1(100);
    }
}
