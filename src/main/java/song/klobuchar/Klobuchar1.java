package song.klobuchar;
import static java.lang.Math.*;
/**
 * Created by Song on 2016/11/13.
 */
public class Klobuchar1 {
    //地球半径km
    private static final double R = 6371;
    //电离层高度km
    private static final double H = 350;
    //地理北磁极经纬度
    private static final double FIs = 78.3 * PI /180.0;
    private static final double Lams = 69 *PI/180.0;
    private static final double t = 1.728128783700988e+005;  // 本周当前时间

    //1
    public static double getAngleFi(){
        double angelZ = asin(R*cos(El_az.el_az_0)/(R+H));
        double angelFi = PI/4.0 - El_az.el_az_0 - angelZ;
        return angelFi;
    }
    //2
    public static double getLatQ(){
        double latQ = asin(sin(Rec_llh.lat)*cos(getAngleFi())+cos(Rec_llh.lat)*sin(getAngleFi())*cos(El_az.el_az_1));
        return latQ;
    }
    //3
    public static double getLonQ(){
        double lonQ = Rec_llh.lon+asin(sin(getAngleFi())*sin(El_az.el_az_1)/cos(getLatQ()));
        return lonQ;
    }
    //4
    public  static double getFIqc(){
        double FIqc = asin(sin(getLatQ())*sin(FIs)+cos(getLatQ())*cos(FIs)*cos(getLonQ()-Lams));
        return FIqc;
    }
    //5
    public  static double getTq(){
        double floor = floor(t/86400.0);
        double UTC = (t-floor*86400.0)*24.0;
        double tq = (getLonQ()*360/(2.0*PI*15))+UTC;
        return tq;
    }
    //6
    public static double inno(){
        double a = 0.0,b=0.0;
        for(int i=0;i<4;i++){
            a+=Eph.Alpha[i]*(getFIqc()/180);
            b+=Eph.Beta[i]*(getFIqc()/180);
        }
        double T1 = 5e-9+cos(2*PI*(3600*getTq()-50400)/b)*a;
        double angelZ = asin(R*cos(El_az.el_az_0)/(R+H));
        double secZ =1.0/cos(angelZ);
        double T = secZ*T1;
        return T;
    }

    public static void main(String [] args){
        System.out.println(inno());
    }
}
