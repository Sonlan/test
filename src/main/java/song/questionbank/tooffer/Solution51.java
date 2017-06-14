package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/13.
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 * 思路：分别从前后相乘，再组合起来，动态规划
 */
public class Solution51 {
    public int[] multiply(int[] A) {
        int [] B = new int [A.length];
        if(null == A || 0==A.length) return B;
        int [] forward = new int[A.length];
        int [] backward = new int[A.length];

        forward[0] = backward[0] = 1;

        for(int i=1;i<A.length;i++){
            forward[i] = A[i-1]*forward[i-1];
            backward[i] = A[A.length-i]*backward[i-1];
        }
        for(int i=0;i<B.length;i++){
            B[i] = forward[i]*backward[B.length-i-1];
        }
        return B;
    }
}
