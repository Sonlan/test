package song;

import java.util.Scanner;

/**
 * Created by Song on 2017/5/25.
 * 转发分享是目前内容传播的主要手段之一,假设一篇文章发出后第二天能被20个转发分享,第三天能被10个人转发分享(第四天就不能转发了)
 * .同时被转发的文章也能再次被转发分享(转发后的文章第二天能被20个再次转发分享,第三天能被10个人转发分享),问N天后,这篇文章被转发了多少次？
 */
public class Main {
    private static int limitDay = 0;

    public static int count(int day,int initDay){
        if(4 <= day || initDay>limitDay) return 0;
        if(2 == day) {
            return 20+20*count(day+1,initDay+1)+20*count(2,initDay+1);
        }
        if(3 == day) {
            return 10+10*count(2,initDay+1);
        }
        return 0;
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int limitN = scanner.nextInt();
        limitDay = limitN;
        int totalNum = count(2,2);
        System.out.println(totalNum);

    }
}
