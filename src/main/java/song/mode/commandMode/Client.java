package song.mode.commandMode;

/**
 * Created by Song on 2016/10/21.
 */
public class Client {
    public static void main(String [] args){
        //初始化调用者
        Invoker invoker = new Invoker();
        //执行命令1
        invoker.setCommand(new Command1());
        invoker.action();
        //执行命令2
        invoker.setCommand(new Command2());
        invoker.action();
    }
}
