package song.decorate;

/**
 * Created by Song on 2016/8/31.
 * 装饰基类，采用代理模式，传入待装饰对象
 */
public class Decorator extends Component {
    //装饰对象
    private Component component;
    //构造函数
    public Decorator(Component component){
        this.component = component;
    }
    @Override
    public void promote() {
        this.component.promote();
    }
}
