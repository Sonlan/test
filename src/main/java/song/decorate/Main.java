package song.decorate;

/**
 * Created by Song on 2016/8/31.
 */
public class Main {
    public static void main(String [] args){
        Component component;
        //得到基本待修饰对象
        component = new ConcreteComponent();
        //首次修饰
        component = new PriceDecorator(component);
        //再一次修饰
        component = new NumDecorator(component);

        component.promote();
    }
}
