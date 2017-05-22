package song.mode.ProxyMode;

/**
 * Created by Song on 2016/10/9.
 */
public class Client {
    public static void main(String [] args){
        Proxy lawyer = new Proxy(new RealSubject("路人甲"));
        lawyer.service();
    }
}
