package song.commandMode;

/**
 * Created by Song on 2016/10/21.
 * 抽象命令
 */
public abstract class Command {
    //执行者
    protected Operator operator;
    public Command(Operator _operator){this.operator=_operator;}
    //执行命令
    public abstract void execute();
}
