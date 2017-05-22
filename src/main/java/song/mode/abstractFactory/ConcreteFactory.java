package song.mode.abstractFactory;

/**
 * Created by Song on 2016/9/1.
 * 具体工厂实现类
 */
public class ConcreteFactory extends AbstractFactory {
    @Override
    public AbstractProduct createProductA() {
        return new ProductA();
    }

    @Override
    public AbstractProduct createProductB() {
        return new ProductB();
    }
}
