package song.questionbank.tooffer;

/**
 * Created by Administrator on 2017/3/6.
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 */
public class Solution7 {
    //递归超时
    /*public int Fibonacci(int n) {
        if(0>=n) return 0;
        if(1==n) return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
    }*/
    public  static int[] num=new int[100];
    static {
        num[0]=0;
        num[1]=1;
        for(int i=2;i<100;i++){
            num[i]=num[i-1]+num[i-2];
        }
    }
    public int Fibonacci(int n) {
        int[] num=new int[100];
        num[0]=0;
        num[1]=1;
        for(int i=2;i<100;i++){
            num[i]=num[i-1]+num[i-2];
        }

        return num[n];
    }

    public static void main(String [] args){
        Solution7 solution7 = new Solution7();
        for(int i=0;i<40;i++) {
            long start = System.currentTimeMillis();
            System.out.println(solution7.Fibonacci(i)+"   "+(System.currentTimeMillis() - start));
        }
    }
}
