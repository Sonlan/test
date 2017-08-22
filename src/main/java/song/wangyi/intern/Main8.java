package song.wangyi.intern;

import java.util.*;

/**
 * Created by Song on 2017/8/13.
 * 小易老师是非常严厉的,它会要求所有学生在进入教室前都排成一列,并且他要求学生按照身高不递减的顺序排列。有一次,n个学生在列队的时候,小易老师正好去卫生间了。学生们终于有机会反击了,于是学生们决定来一次疯狂的队列,他们定义一个队列的疯狂值为每对相邻排列学生身高差的绝对值总和。由于按照身高顺序排列的队列的疯狂值是最小的,他们当然决定按照疯狂值最大的顺序来进行列队。现在给出n个学生的身高,请计算出这些学生列队的最大可能的疯狂值。小易老师回来一定会气得半死。
 输入描述:
 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示学生的人数
 第二行为n个整数h[i](1 ≤ h[i] ≤ 1000),表示每个学生的身高


 输出描述:
 输出一个整数,表示n个学生列队可以获得的最大的疯狂值。

 如样例所示:
 当队列排列顺序是: 25-10-40-5-25, 身高差绝对值的总和为15+30+35+20=100。
 这是最大的疯狂值了。

 输入例子1:
 5
 5 10 25 40 25

 输出例子1:
 100
 */
//思路：找出以最大值为中心，此最小值分列两侧，再次最大值分列两侧，如此反复,通过90%
    //需要对比以最小值为中心，两侧铺开的方式，取二者最大值，则100%
public class Main8 {
    public static int maxCrazy(int n,int [] h){
        if(null == h || 1 >= h.length) return 0;
        Arrays.sort(h);
        int max=0;
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(h[n-1]);
        boolean flag=false;
        int i=0,j=n-2;
        while (list.size()<n){
            if(!flag){
                list.add(0,h[i]);
                if(i+1<=j)
                    list.add(h[i+1]);
                i +=2;
                flag = true;
            }else {
                list.add(0,h[j]);
                if(j-1>=i)
                    list.add(h[j-1]);
                j-=2;
                flag = false;
            }
        }
        max = Math.abs(list.get(1)-list.get(0));
        for(int k=2;k<list.size();k++){
            max+=Math.abs(list.get(k)-list.get(k-1));
        }

        list = new LinkedList<Integer>();
        list.add(h[0]);
        flag=true;
        i=1;j=n-1;
        while (list.size()<n){
            if(!flag){
                list.add(0,h[i]);
                if(i+1<=j)
                    list.add(h[i+1]);
                i +=2;
                flag = true;
            }else {
                list.add(0,h[j]);
                if(j-1>=i)
                    list.add(h[j-1]);
                j-=2;
                flag = false;
            }
        }
        int max1 = Math.abs(list.get(1)-list.get(0));
        for(int k=2;k<list.size();k++){
            max1+=Math.abs(list.get(k)-list.get(k-1));
        }
        return max>max1?max:max1;
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
        int [] h = toInt(scanner.nextLine().split(" "));
        System.out.println(maxCrazy(n,h));
    }
}
