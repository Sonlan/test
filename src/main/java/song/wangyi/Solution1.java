package song.wangyi;

import java.util.Scanner;

/**
 * Created by Song on 2017/8/11.
 * 一种双核CPU的两个核能够同时的处理任务，现在有n个已知数据量的任务需要交给CPU处理，假设已知CPU的每个核1秒可以处理1kb，每个核同时只能处理一项任务。n个任务可以按照任意顺序放入CPU进行处理，现在需要设计一个方案让CPU处理完这批任务所需的时间最少，求这个最小的时间。
 输入描述:
 输入包括两行：
 第一行为整数n(1 ≤ n ≤ 50)
 第二行为n个整数length[i](1024 ≤ length[i] ≤ 4194304)，表示每个任务的长度为length[i]kb，每个数均为1024的倍数。


 输出描述:
 输出一个整数，表示最少需要处理的时间
 */
public class Solution1 {
    public int countTime(int length,int [] task){
        int sum=0;
        int [] weight = new int[length];
        for(int i=0;i<length;i++){
            weight[i] = task[i]>>10;
            sum+=weight[i];
        }
        int maxWeight = sum/2;
        //value[i][j]:前i个数在不超过总权重为j的情况下，最大总权重
        int [][] value = new int[length+1][maxWeight+1];
        for(int i=0;i<=length;i++){
            //总权重为0的情况
            value[i][0] = 0;
        }
        for(int j=0;j<=maxWeight;j++){
            //没有数的情况
            value[0][j] = 0;
        }
        for(int i=1;i<=length;i++){
            for(int j=1;j<=maxWeight;j++){
                //当前的第i个数权重小于最大总权重
                if(weight[i-1]<=j){
                    //前i-1个数按总权重j时的最大总权重
                    int arg1 = value[i-1][j];
                    //前i-1个数按照总权重 j - 当前数权重的最大总权重  +  当前权重
                    int arg2 = value[i-1][j-weight[i-1]] + weight[i-1];
                    //取二者较大值
                    value[i][j] = arg1>arg2?arg1:arg2;
                }else {//放不进去
                    value[i][j] = value[i-1][j];
                }
            }
        }
        return (sum- value[length][maxWeight])<<10;
    }

    public int [] toInt(String [] args){
        int [] result = new int[args.length];
        int i=0;
        for(String val:args){
            result[i++] = Integer.parseInt(val);
        }
        return result;
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        String tasks = scanner.nextLine();
        String [] args1 = tasks.split(" ");
        Solution1 sol = new Solution1();
        System.out.println(sol.countTime(args1.length,sol.toInt(args1)));
    }
}
