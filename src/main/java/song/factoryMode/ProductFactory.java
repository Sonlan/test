package song.factoryMode;

/**
 * Created by Song on 2016/8/31.
 * 工厂接口
 */
public interface ProductFactory {
    //创建实例接口
    public <T extends Product> T createProduct(Class<T> c);
}
