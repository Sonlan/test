package song.klobuchar;
import static java.lang.Math.*;
/**
 * Created by Song on 2016/11/13.
 * 电离层时延计算流程实现类
 */
public class Klobuchar {
    //地球半径km
    private static final double R = 6371;
    //电离层高度km
    private static final double H = 350;
    //地理北磁极经纬度
    private static final double FIs = 78.3 * PI /180.0;
    private static final double Lams = 69.0 *PI/180.0;
    private static final double t = 1.728128783700988e+005;  // 本周当前时间

    //1.计算地心角
    public static double getAngleFi(){
        double angelZ = asin(R*cos(El_az.el_az_0)/(R+H));
        double angelFi = PI/4.0 - El_az.el_az_0 - angelZ;
        return angelFi;
    }
    //2.计算穿刺点的星下点Q的地理纬度
    public static double getLatQ(){
        double latQ = asin(sin(Rec_llh.lat)*cos(getAngleFi())+cos(Rec_llh.lat)*sin(getAngleFi())*cos(El_az.el_az_1));
        return latQ;
    }
    //3.计算穿刺点的星下点Q的地理经度
    public static double getLonQ(){
        double lonQ = Rec_llh.lon+asin(sin(getAngleFi())*sin(El_az.el_az_1)/cos(getLatQ()));
        return lonQ;
    }
    //4.将星下点Q的地理纬度换算为地磁纬度
    public  static double getFIqc(){
        double FIqc = asin(sin(getLatQ())*sin(FIs)+cos(getLatQ())*cos(FIs)*cos(getLonQ()-Lams));
        return FIqc;
    }
    //5.换算穿刺点的星下点Q处的地方时
    public  static double getTq(){
        double floor = floor(t/86400.0);
        double UTC = (t-floor*86400.0)*24.0;
        double tq = (getLonQ()*360.0/(2.0*PI*15.0))+UTC;
        return tq;
    }
    //6.计算单频信号的电离层天顶延时,倾斜因子以及实际电离层时延
    //返回最终计算得到的电离层时延
    public static double inno(){
        double a = 0.0,b=0.0;
        for(int i=0;i<4;i++){
            a+=Eph.Alpha[i]*pow((getFIqc()/180.0),i+1);
            b+=Eph.Beta[i]*pow((getFIqc()/180.0),i+1);
        }
        double T1 = 5e-9+cos(2.0*PI*(3600.0*getTq()-50400.0)/b)*a;
        double angelZ = asin(R*cos(El_az.el_az_0)/(R+H));
        double secZ =1.0/cos(angelZ);
        double T = secZ*T1;
        return T;
    }
    //主方法入口
    public static void main(String [] args){
        //调用inno()方法，打印计算得到的实际电离层时延
        double iono_delay_time = inno();
        System.out.println("计算得实际电离层时延为："+iono_delay_time+"秒");
        System.out.println("给定的参考电离层时延为5.159186742310326e-9秒");
        System.out.println("与给定的电离层时延误差大小为："+(iono_delay_time-5.159186742310326e-9));
    }
}
