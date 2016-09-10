package song.abstractFactory;

/**
 * Created by Song on 2016/9/1.
 */
public class Main {
    public static void main(String [] args){
        //创建具体工厂
        AbstractFactory factory = new ConcreteFactory();
        //获取产品实例
        ProductA productA = (ProductA) factory.createProductA();
        ProductB productB = (ProductB)factory.createProductB();

        //打印产品信息
        productA.introduction();
        productB.introduction();
    }
}
