package song.mode.strategyMode;

/**
 * Created by Song on 2016/10/28.
 * 策略模式
 */
//策略接口
interface IStrategy {
    //具体业务逻辑
    void execute();
}
//具体策略1
class Strategy1 implements IStrategy{
    public void execute() {
        System.out.println("执行策略1");
    }
}
//具体策略2
class Strategy2 implements IStrategy{
    public void execute() {
        System.out.println("执行策略2");
    }
}
//策略访问接口封装类
class Context {
    private IStrategy strategy;
    public Context(IStrategy _strategy){
        this.strategy = _strategy;
    }
    public void execute(){
        this.strategy.execute();
    }
}

//场景测试类
public class Client {
    public static void main(String [] args){
        new Context(new Strategy1()).execute();
        new Context(new Strategy2()).execute();
    }
}
