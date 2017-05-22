package song.mode.commandMode;

/**
 * Created by Song on 2016/10/21.
 * 具体命令2
 */
public class Command2 extends Command {
    public Command2(Operator _operator){super(_operator);}
    public Command2(){super(new Operator2());}
    @Override
    public void execute() {
        super.operator.doSomething();
    }
}
