package song.mode.handlerChainMode;

/**
 * Created by Song on 2016/10/23.
 * 抽象处理者
 */
public abstract class Handler {
    private Handler nextHandler;  //责任链的下一环
    //每一环责任链都必须对请求作出处理
    public final Response handler(Request request){
        Response response = null;
        //判断请求级别是否是自己所处理的
        if(request.getRequestLevel().equals(this.getHandlerLever())) response=this.echo(request);
        else{
            //存在下一环
            if(null != this.nextHandler){
                response=this.nextHandler.echo(request);
            }else{
                //TO-DO
            }
        }
        return response;
    }
    //设置自己的下一环
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //获取自己所处理消息的等级
    public abstract Level getHandlerLever();
    //具体处理方式
    public abstract Response echo(Request request);
}
