package song.decorate;

/**
 * Created by Song on 2016/8/31.
 * 价格装饰类
 */
public class PriceDecorator extends Decorator {
    //构造函数
    public PriceDecorator(Component component){
        super(component);
    }

    @Override
    public void promote() {
        super.promote();
        System.out.println("原价可是999元哦！！");
    }
}
