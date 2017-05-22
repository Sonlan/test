package song.mode.templateMode;

/**
 * Created by Song on 2016/9/6.
 * 抽象模板
 */
public abstract class AbstractClass {
    //步骤0（基本方法）
    protected abstract void step0();
    //步骤1（基本方法）
    protected abstract void step1();
    //模板方法
    public void templateMethod(){
        //确定基本方法的调用顺序，完成特定功能
        this.step0();
        this.step1();
    }
}
