package song.questionbank.tooffer;

/**
 * Created by Song on 2017/6/13.
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 * 思路：二进制运算本质，异或求和，与求进位
 */
public class Solution48 {
    public int Add(int num1,int num2) {
        int co = num1&num2;
        int sum  = num1^num2;
        int temp;
        while (co!=0){
            temp =sum^(co<<1);
            co = (co<<1)&sum;
            sum = temp;
        }
        return sum;
    }

    public static void main(String [] args){
        System.out.println(new Solution48().Add(10,-9));
    }
}
