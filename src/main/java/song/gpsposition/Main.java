package song.gpsposition;
import static java.lang.Math.*;
/**
 * Created by Song on 2016/11/15.
 * 通过星历计算卫星坐标
 */
public class Main implements Ephemeris{
    public static void main(String [] args){
        //计算GPS卫星运行的平均速度n
        double a=pow(Ephemeris.SqrtA,2);
        double n=sqrt(Ephemeris.mu/(pow(a,3)))+Ephemeris.Delta_n;

        //计算归化时间Delta_t
        double Delta_t=Ephemeris.t-Ephemeris.Toe;

        //计算观测历元t的平近点角M
        double M=Mu0+n*Delta_t;

        //计算偏近点角E
        double eps=1e-20;
        double E=M;
        double tol=1;
        double E0=0;
        while (tol>eps) { //不动点迭代法
            E0 = E;
            E = M + (Ecc) * sin(E0);
            tol = abs(E - E0);
        }
        //计算卫星的地心矢径r0
        double r0=a*(1-Ecc*cos(E));

        //计算真近点角f
        //f=2*atan(sqrt((1+Ecc)/(1-Ecc))*tan(E/2));
        double f=atan((sqrt(1-pow(Ecc,2))*sin(E))/(cos(E)-Ecc));

        //计算升交点角距Phi0
        double Phi0=Small_Omega+f;

        //计算摄动改正项：Delta_u,Delta_r,Delta_i
        double Delta_u=C_us*sin(2*Phi0)+C_uc*cos(2*Phi0);
        double Delta_r=C_rs*sin(2*Phi0)+C_rc*cos(2*Phi0);
        double Delta_i=C_is*sin(2*Phi0)+C_ic*cos(2*Phi0);

        //计算经过摄动改正的升交点角距Phi，卫星矢径r，和轨道面倾角I
        double Phi=Phi0+Delta_u;
        double r=r0+Delta_r;
        double I=I0+Delta_i+I_Dot*Delta_t;

        //计算观测历元t的升交点经度Omegak
        double Omegak=Omega0+(Omega_dot-omegae)*Delta_t-omegae*Toe;

        //计算卫星在轨道平面坐标系中的位置
        double x0=r*cos(Phi);
        double y0=r*sin(Phi);
        double z0=0;

        //计算卫星在地固坐标系下的坐标
        double x=x0*cos(Omegak)-y0*cos(I)*sin(Omegak);
        double y=x0*sin(Omegak)+y0*cos(I)*cos(Omegak);
        double z=y0*sin(I)+z0*cos(I);

        //输出卫星坐标
        System.out.printf("（修正后）卫星在地固坐标系中的坐标：\n  X=%.10f   Y=%.10f   Z=%.10f\n",x,y,z);
        //老师给的结果：卫星位置：X=7073881.4181256806  Y=23901970.8378255780  Z=-32955601.5025106560
        double X=7073881.4181256806,Y=23901970.837825578,Z=-32955601.5025106560;//修正后的，非GEO
        System.out.printf ("与给定的结果的偏差为：\n  D_X=%.10f   D_Y=%.10f   D_Z=%.10f\n",x-X,y-Y,z-Z);
    }
}
