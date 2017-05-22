package song.mode.decorate;

/**
 * Created by Song on 2016/8/31.
 * 销量装饰器
 */
public class NumDecorator extends Decorator {
    public NumDecorator(Component component){
        super(component);
    }

    @Override
    public void promote() {
        super.promote();
        System.out.println("本书销量本年度第一，达到一亿册哟！！");
    }
}
