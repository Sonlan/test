package song.decorate;

/**
 * Created by Song on 2016/8/31.
 * 具体待装饰类
 */
public class ConcreteComponent extends Component {
    @Override
    public void promote() {
        System.out.println("这是一本书，售价99元");
    }
}
