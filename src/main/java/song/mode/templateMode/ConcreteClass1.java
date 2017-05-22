package song.mode.templateMode;

/**
 * Created by Song on 2016/9/6.
 * 具体类1
 */
public class ConcreteClass1 extends AbstractClass {
    @Override
    protected void step0() {
        System.out.println("步骤0：拿起筷子");
    }

    @Override
    protected void step1() {
        System.out.println("步骤1：开始吃饭");
    }
}
