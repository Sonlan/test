package song.wangyi.intern;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Song on 2017/8/13.
 * 如果一个数列S满足对于所有的合法的i,都有S[i + 1] = S[i] + d, 这里的d也可以是负数和零,我们就称数列S为等差数列。
 小易现在有一个长度为n的数列x,小易想把x变为一个等差数列。小易允许在数列上做交换任意两个位置的数值的操作,并且交换操作允许交换多次。但是有些数列通过交换还是不能变成等差数列,小易需要判别一个数列是否能通过交换操作变成等差数列
 输入描述:
 输入包括两行,第一行包含整数n(2 ≤ n ≤ 50),即数列的长度。
 第二行n个元素x[i](0 ≤ x[i] ≤ 1000),即数列中的每个整数。


 输出描述:
 如果可以变成等差数列输出"Possible",否则输出"Impossible"。

 输入例子1:
 3
 3 1 2

 输出例子1:
 Possible
 */
public class Main5 {
    private static final String P = "Possible";
    private static final String N = "Impossible";
    public static String valid(int n, int [] x){
        if(n<3) return P;
        Arrays.sort(x);
        int pre = x[1]-x[0],tmp;
        for(int i=2;i<n;i++){
            tmp = x[i]-x[i-1];
            if(tmp != pre){
                return N;
            }
        }
        return P;
    }

    public static int [] toInt(String [] args){
        int [] result = new int[args.length];
        int i=0;
        for(String val:args){
            result[i++] = Integer.parseInt(val);
        }
        return result;
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int [] x = toInt(scanner.nextLine().split(" "));
        System.out.println(valid(n,x));
    }
}
