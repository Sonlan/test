package song.homework.klobuchar;

/**
 * Created by Song on 2016/11/13.
 * 卫星星历数据
 */
public interface Eph {
    /****  以下为卫星的星历  *****/
    double Omega0= -0.1440958325;
    double I0= 0.9591287334;
    double SqrtA= 6493.40329395;
    double Ecc= 0.0199939287;
    double Small_Omega= 0.0002091509;
    double Mu0= 2.237833587;
    double Delta_n= 1.52284e-009;
    double I_Dot= 3.7033e-010;
    double Omega_dot= -2.1818e-009;
    double IODE= 10;
    double C_uc= -4.7167e-006;
    double C_us= 7.1045e-006;
    double C_ic= -4.06e-008;
    double C_is= 1.091e-007;
    double C_rc= 24.79954;
    double C_rs= -153.72865;
    double IODC= 10;
    double URAI= 0;
    double Toe= 172800;
    double TGD1= 0;
    double TGD2= 0;
    double Toc = 172800;
    double a0  = 0.000360131;
    double a1  = 1.5715606e-011;
    double a2  = 5.787e-018;
    /****  以下为电离层参数  只使用 Alpha0-Alpha3、 Beta0-Beta3   ******/
    double Alpha0= 1.6746e-008;
    double Alpha1= -1.6035e-009;
    double Alpha2=-3.6417e-007;
    double Alpha3= -6.4647e-007;
    double [] Alpha = {Alpha0,Alpha1,Alpha2,Alpha3};
    double Beta0= 121010;
    double Beta1= -124730;
    double Beta2= -494460;
    double Beta3= -67801;
    double [] Beta = {Beta0,Beta1,Beta2,Beta3};
    double Gamma0= 0;
    double Gamma1= 0;
    double Gamma2= 0;
    double Gamma3= 0;
    double A1= 0.0;
    double B= 0.0;
}
