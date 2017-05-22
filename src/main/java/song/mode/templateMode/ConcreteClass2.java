package song.mode.templateMode;

/**
 * Created by Song on 2016/9/6.
 */
public class ConcreteClass2 extends AbstractClass {
    @Override
    protected void step0() {
        System.out.println("步骤0：拿起刀叉");
    }

    @Override
    protected void step1() {
        System.out.println("步骤1：开始吃饭");
    }
}
