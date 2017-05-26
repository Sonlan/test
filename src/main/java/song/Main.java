package song;

import java.util.Scanner;

/**
 * Created by Song on 2017/5/25.
 * 转发分享是目前内容传播的主要手段之一,假设一篇文章发出后第二天能被20个转发分享,第三天能被10个人转发分享(第四天就不能转发了)
 * .同时被转发的文章也能再次被转发分享(转发后的文章第二天能被20个再次转发分享,第三天能被10个人转发分享),问N天后,这篇文章被转发了多少次？
 */
public class Main {
    private int totalNum = 0;
    private int limitDay = 0;
    private int initDay = 1;

    private void count(int day,int num,int initDay){
        if(4 <= day || initDay>=limitDay) return ;
        if(2 == day) {
            this.totalNum+=20*num;
            count(day++,20,initDay++);
        }
        if(3 == day) {
            this.totalNum+=10*num;
            count(day++,10,initDay++);
        }
    }
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);

    }
}
