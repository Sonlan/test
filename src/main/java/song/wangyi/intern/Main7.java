package song.wangyi.intern;

import java.util.Scanner;

/**
 * Created by Song on 2017/8/13.
 * 小易有一个长度为n的整数序列,a_1,...,a_n。然后考虑在一个空序列b上进行n次以下操作:
 1、将a_i放入b序列的末尾
 2、逆置b序列
 小易需要你计算输出操作n次之后的b序列。
 输入描述:
 输入包括两行,第一行包括一个整数n(2 ≤ n ≤ 2*10^5),即序列的长度。
 第二行包括n个整数a_i(1 ≤ a_i ≤ 10^9),即序列a中的每个整数,以空格分割。


 输出描述:
 在一行中输出操作n次之后的b序列,以空格分割,行末无空格。

 输入例子1:
 4
 1 2 3 4

 输出例子1:
 4 2 1 3
 */
//观察序列可知，以1为分割线，将序列按位置i分为了左右奇数与偶数，以下数字只代表第i位
    //1             1
    //21            2
    //312           3
    //4213          4
    //53124         5
    //642135        6
    //7531246       7
public class Main7 {
/*    public static String process(int n,String [] a){
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (i<n){
            sb.append(a[i]);
            sb.reverse();
            sb.append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }*/

    public static String process(int n,String [] a){
        if(null == a || 0== a.length) return null;
        if(1 == a.length) return a[0];
        StringBuilder sb = new StringBuilder();
        int index = n - 1;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if (!flag && index>=0) {
                sb.append(a[index] + " ");
                index -= 2;
            } else {
                if (index < 0){
                    if(n%2 !=0) index = 1;
                    else index = 0;
                    flag = true;
                }
                sb.append(a[index] + " ");
                index += 2;
            }
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String [] a = scanner.nextLine().split(" ");
        System.out.println(process(n,a));
    }
}
