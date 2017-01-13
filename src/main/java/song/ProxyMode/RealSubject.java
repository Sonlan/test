package song.ProxyMode;

/**
 * Created by Song on 2016/10/9.
 * 被代理类的一个实例
 */
public class RealSubject implements Subject {
    private String name;  //名称
    public RealSubject(String name){
        this.name = name;
    }
    public void service() {
        System.out.println("我是"+this.name+"，我要打民事纠纷官司");
    }
}
