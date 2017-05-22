package song.mode.abstractFactory;

/**
 * Created by Song on 2016/9/1.
 * 抽象工厂类
 */
public abstract class AbstractFactory {
    //创建A类产品实例
    public abstract AbstractProduct createProductA();
    //创建B类产品实例
    public abstract AbstractProduct createProductB();
}
