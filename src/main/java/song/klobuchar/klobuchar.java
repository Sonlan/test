package song.klobuchar;

import static java.lang.Math.PI;
import static java.lang.Math.floor;

/**
 * Created by Song on 2016/11/13.
 */
public class klobuchar {
    public static final double T = 1.728128783700988e+005;
    //地理北磁极经纬度
    private static final double FIs = 78.3 * PI /180.0;
    private static final double Lams = 69 *PI/180.0;
    public static double inno(){

        return getSecZ()*(5e-9+getA()*Math.cos(2.0*Math.PI*(getT()-14)/getP()));
    }

    public static double getFIm(){
        double EA = (445.0/(El_az.el_az_0*360.0/(2*Math.PI)+20.0)-4.0)*PI/180.0;
        double FIip = FIs+EA*Math.cos(El_az.el_az_1);
        double Lamip = Lams+EA*Math.sin(El_az.el_az_1)/Math.cos(FIs);
        double FIm = (FIip*180.0/PI+11.6*Math.cos(Lamip*180.0/PI-291))*PI/180.0;
        System.out.println("FIm:"+FIm);
        return FIm;
    }

    public static double getSecZ(){
        double SecZ = 1.0+2*Math.pow((96.0-El_az.el_az_0*180.0/PI)/90.0,3.0);
        System.out.println("SecZ:"+SecZ);
        return SecZ;
    }

    public static double getA(){
        double A = 0.0;
        for(int i =0 ; i<4;i++){
            A+=Eph.Alpha[i];
        }
        System.out.println("A:"+A);
        return A;
    }

    public static double getP(){
        double P = 0.0;
        for(int i =0 ; i<4;i++){
            P+=Eph.Beta[i];
        }
        System.out.println("P:"+P);
        return P;
    }

    public static double getT(){
        double EA = (445.0/(El_az.el_az_0*360.0/(2*Math.PI)+20.0)-4.0)*PI/180.0;
        double Lamip = Lams+EA*Math.sin(El_az.el_az_1)/Math.cos(FIs);
        double floor = floor(T/86400.0);
        double UTC = (T-floor*86400.0)*24.0;
        double tq = (Lamip*360/(2.0*PI*15))+UTC;
        return tq;
    }

    public static void main(String [] args){
        System.out.println(inno());
    }

}
