/**
 * Created by Song on 2016/8/29.
 * 单例模式
 */
public class Singleton {
    private static final Singleton singleton = new Singleton();
    private static int i = 0;
    //私有化构造方法
    private Singleton(){

    }
    //类中其他功能代码，尽量采用static 方式
    public void doSomething(){
        i++;
    }
    public void print(){
        System.out.println(i);
    }
    //返回该类实例化对象
    public static Singleton getInstance(){
        return singleton;
    }
}
