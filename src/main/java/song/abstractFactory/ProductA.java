package song.abstractFactory;

/**
 * Created by Song on 2016/9/1.
 * A类产品
 */
public class ProductA extends AbstractProduct {
    @Override
    public void introduction() {
        System.out.println("这是产品A");
    }
}
