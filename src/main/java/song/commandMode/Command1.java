package song.commandMode;

/**
 * Created by Song on 2016/10/21.
 * 具体命令1
 */
public class Command1 extends Command {
    public Command1(Operator _operator){super(_operator);}
    public Command1(){super(new Operator1());}
    @Override
    public void execute() {
        super.operator.doSomething();
    }
}
