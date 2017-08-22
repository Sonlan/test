package song.wangyi.intern;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Song on 2017/8/12.
 * 小易将n个棋子摆放在一张无限大的棋盘上。第i个棋子放在第x[i]行y[i]列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有i(1 ≤ i ≤ n)个棋子所需要的最少操作次数.

 输入描述:
 输入包括三行,第一行一个整数n(1 ≤ n ≤ 50),表示棋子的个数
 第二行为n个棋子的横坐标x[i](1 ≤ x[i] ≤ 10^9)
 第三行为n个棋子的纵坐标y[i](1 ≤ y[i] ≤ 10^9)


 输出描述:
 输出n个整数,第i个表示棋盘上有一个格子至少有i个棋子所需要的操作数,以空格分割。行末无空格

 如样例所示:
 对于1个棋子: 不需要操作
 对于2个棋子: 将前两个棋子放在(1, 1)中
 对于3个棋子: 将前三个棋子放在(2, 1)中
 对于4个棋子: 将所有棋子都放在(3, 1)中

 输入例子1:
 4
 1 2 4 9
 1 1 1 1

 输出例子1:
 0 1 3 10
 */
public class Main2 {
    //50%,基于一个前提，聚集点一定是n个点之一，事实上不是，例如菱形四点，移到其中心点必然是最近的,其实可以把x和y轴分离开来，所有聚集点，必然在以二者围成的矩形区域内，而不一定是其中某一点。
    //另外对于k个点的k聚集点，其单轴坐标必然是其中某点的单轴坐标，可以画图看看。对于n个点的k聚集点，可以看成选择最适合的k个点的k聚集点，道理仍然适用。
/*    public static int [] process(int n,int [] x, int [] y){
        //爆搜，dp[i][j]第j个棋子到第i个棋子的距离
        int [] result = new int[n];
        int [][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j == i) dp[i][j] = 0;
                else{
                    dp[i][j] = Math.abs(x[i]-x[j])+Math.abs(y[i]-y[j]);
                }
            }
            Arrays.sort(dp[i]);
        }
        result[0] = 0;
        int min,curRow;
        for(int i=1;i<n;i++){
            min=Integer.MAX_VALUE;
            for(int j=0;j<n;j++) {
                curRow = 0;
                for (int k = 0; k < i + 1; k++) {
                    curRow += dp[j][k];
                }
                min = min<curRow?min:curRow;
            }
            result[i] = min;
        }
        return result;
    }*/

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
        int [] y = toInt(scanner.nextLine().split(" "));
        int [] result = process(n,x,y);
        for(int i=0;i<result.length;i++){
            if(i<result.length-1){
                System.out.printf("%d ",result[i]);
            }else {
                System.out.printf("%d",result[i]);
            }
        }
    }

    public static int [] process(int n,int [] x, int [] y){
        //爆搜，dp[i][j]第j个棋子到第i个棋子的距离
        int [] result = new int[n];
        result[0] = 0;
        int min,sum;
        List<Integer> list = new LinkedList<>();
        //逐个赋值
        for(int k = 1;k<n;k++) {
            min = Integer.MAX_VALUE;
            //遍历所有x y 组合
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    //计算每个点到（x[i],y[j]）的距离，对第k+1个聚集点，选出最小的前k+1个距离做累加和，取最先累加和即为结果
                    list.clear();
                    for(int p=0;p<n;p++){
                        int distance  = Math.abs(x[p]-x[i])+Math.abs(y[p]-y[j]);
                        if(list.size() ==0) list.add(distance);
                        else if(list.size()<k+1){
                            if(distance>=list.get(list.size()-1)){
                                list.add(distance);
                            }else {
                                list.add(list.size()-1,distance);
                            }
                        }
                    }
                    sum=0;
                    for(int val:list){
                        sum+=val;
                    }
                    min = min<sum?min:sum;
                }
            }
            result[k] = min;
        }
        return result;
    }
}
