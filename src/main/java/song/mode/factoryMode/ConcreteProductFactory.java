package song.mode.factoryMode;

/**
 * Created by Song on 2016/8/31.
 * 工厂接口实现类
 */
public class ConcreteProductFactory implements ProductFactory {
    public <T extends Product> T createProduct(Class<T> c) {
        Product product;
        try{
            product = (Product) Class.forName(c.getName()).newInstance();
        }catch (Exception e){
            return null;
        }
        return  (T)product;
    }
}
