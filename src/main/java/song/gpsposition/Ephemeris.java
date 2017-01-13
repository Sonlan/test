package song.gpsposition;
import  static java.lang.Math.*;
/**
 * Created by Song on 2016/11/15.
 * 试验用到的星历及相关数据
 */
public interface Ephemeris {
    double t=1.728128741751984e+005;     //当前时间（接收到卫星信号时间）
    double Omega0= -3.1122016819;        //按参考时间计算的升交点经度
    double I0=0.3*PI;                    //非GEO卫星
    double I0_GEO= 0.0879969068;            //GEO卫星
    double  SqrtA= 6493.27499625;         //长半轴平方根
    double  Ecc= 0.01995786;              //偏心率
    double  Small_Omega= -1.7409228484;   //近地点角距
    double  Mu0= 0.0005884201;           //参考时间的平近点角
    double  Delta_n= -2.4123e-009;         //卫星平均运动速度与计算值之差
    double  I_Dot= -3.4333e-010;           //轨道倾角变化率
    double  Omega_dot= 3.47676e-009;      //升交点经度变化率
    double  C_uc= 4.692e-006;             //纬度幅角的余弦调和改正项的振幅
    double  C_us= -1.10036e-005;          //纬度幅角的正弦调和改正项的振幅
    double  C_ic= 9.01e-008;              //轨道倾角的余弦调和改正项的振幅
    double  C_is= 2.01e-008;              //轨道倾角的正弦调和改正项的振幅
    double  C_rc= 325.73368;             //轨道半径的余弦调和改正项的振幅
    double  C_rs= 146.91074;             //轨道半径的正弦调和改正项的振幅
    double  Toe= 172800;                //星历参考时间
    double  IODC= 10;            //钟差数据龄期
    double  URAI= 0;             //用户距离精度标志
    double  IODE= 10;            //星历数据龄期
    double  Toc = 172800;         //本时段钟差参数参考时间
    double  a0  = -2.72893e-005;   //卫星钟差改正0阶多项式系数
    double  a1  = -6.7531e-014;    //卫星钟差改正1阶多项式系数
    double  a2  = 5.787e-018;      //卫星钟差改正2阶多项式系数

    //---------定义常量---------
    double c=2.99792458e8;  //光速
    double omegae=7.2921151467e-5;  //地球自转角速度
    double mu=3.986004418e14;  //地球引力常数GM
}
