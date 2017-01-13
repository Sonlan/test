package song.factoryMode;

/**
 * Created by Song on 2016/8/31.
 */
public class Main {
    public static void main(String [] args){
        Product product;
        //创建产品工厂实例
        ProductFactory factory = new ConcreteProductFactory();
        //获取产品A实例
        product = factory.createProduct(ProductA.class);
        product.introduction();
        //获取产品B实例
        product = factory.createProduct(ProductB.class);
        product.introduction();
    }
}
