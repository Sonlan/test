package song.wangyi.intern;

import java.util.Scanner;

/**
 * Created by Song on 2017/8/12.
 * 小易为了向他的父母表现他已经长大独立了,他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付x元的房屋租金。当前小易手中已经有f个水果和d元钱,小易也能去商店购买一些水果,商店每个水果售卖p元。小易为了表现他独立生活的能力,希望能独立生活的时间越长越好,小易希望你来帮他计算一下他最多能独立生活多少天。
 输入描述:
 输入包括一行,四个整数x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9),以空格分割


 输出描述:
 输出一个整数, 表示小易最多能独立生活多少天。

 输入例子1:
 3 5 100 10

 输出例子1:
 11
 */
public class Main1 {

    public static int countAliveTime(int x,int f,int d,int p){
        if(x<1 || f<0 || d<=0 || p<0) return 0;
        int tmp = d - f * x;
        int  totalDay=0;
        if(tmp >= 0){
            totalDay = f + tmp/(x+p);
        }else {
            totalDay = d / x;
        }
        return totalDay;
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
        try {
            Scanner scanner = new Scanner(System.in);
            String args1 = scanner.nextLine();
            int[] args2 = toInt(args1.split(" "));
            if (args2.length != 4) System.out.println(0);
            else System.out.println(countAliveTime(args2[0], args2[1], args2[2], args2[3]));
        }catch (Exception e){
            System.out.println(0);
        }
    }
}
