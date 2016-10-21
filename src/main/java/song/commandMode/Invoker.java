package song.commandMode;

/**
 * Created by Song on 2016/10/21.
 * 调用者
 */
public class Invoker {
    private Command command;
    public void setCommand(Command _command){this.command = _command;}
    public void action(){
        this.command.execute();
    }
}
