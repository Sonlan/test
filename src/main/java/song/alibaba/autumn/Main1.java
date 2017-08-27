package song.alibaba.autumn;

import java.util.Scanner;

/**
 * Created by Song on 2017/8/25.
 * 在快递公司干线运输的车辆使用中，存在着单边车和双边车的两种使用场景，例如 北京中心-杭州中心，两个分拨中心到彼此的单量对等，则可以开双边车（即同一辆车可以往返对开），而当两个中心的对发单量不对等时，则会采用单边车，并且双边车的成本是低于单边车的，即将两辆对开的单边车合并为一辆往返的双边车是能够节省运力成本的
 单边车优化原则：
 将单边车优化的规则进行可抽象为以下三种（A,B,C均表示分拨中心）：
 规则-1: A-B单边车，B-A单边车 优化方案：将A-B和B-A的两辆单边车合并为双边；
 规则-2: A-B单边车，B-C单边车，C-A单边车 优化方案：将A-B、B-C、C-A的三辆单边车优化为一辆环形往返车；
 规则-3: A-B单边车，C-A单边车，B、C同省 优化方案：当B、C同省，将A-B、C-A两辆单边优化为一辆环形往返
 问题如下：
 以某快递公司的实际单边车数据为例（线路ID编码;出分拨中心; 出分拨中心所在省;到达分拨中心;到达分拨中心所在省；车型；），进行优化，优化的规则参照以上，并且优先级依次降低，合并的时候需要考虑车型（分为17.5m和9.6m两种）：1、相同车型才能进行合并；2、两辆同方向的9.6m可以与一辆17.5m的对开车型合并优化 说明：优化输出结果按照规则分类，例如rule1： 2016120001+2016120002表示将单边车线路ID编码为2016120001和2016120002按照规则1合并优化
 */
public class Main1 {
    //62进制
    private static final String BASE = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static String genrate(long index){
        StringBuilder sb = new StringBuilder();
        int tmp;
        for(int i=0;i<4;i++){
            tmp = (int)(index/Math.pow(62,3-i));
            index = (long)(index - tmp*Math.pow(62,3-i));
            sb.append(BASE.charAt(tmp));
        }
        return sb.toString();
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        String s;
        while (scanner.hasNext()){
            s = scanner.nextLine();
            if(s.equals("e")) break;
            System.out.println(genrate(Long.parseLong(s)));
        }
    }
}
