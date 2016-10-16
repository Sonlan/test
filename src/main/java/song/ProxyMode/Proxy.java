package song.ProxyMode;

/**
 * Created by Song on 2016/10/9.
 * 代理类
 */
public class Proxy implements Subject {
    private Subject subject;  //被代理类实例
    public Proxy(Subject subject){
        this.subject = subject;
    }
    public void before(){
        System.out.println("代理律师向法庭呈交诉讼书等");
    }
    public void after(){
        System.out.println("代理律师跟相关部分结案");
    }
    public void service() {
        this.before();
        this.subject.service();
        this.after();
    }
}
