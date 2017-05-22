package song.mode.handlerChainMode;

/**
 * Created by Song on 2016/10/23.
 * 具体责任链上的一环
 */
public class Handler1 extends Handler {
    @Override
    public Level getHandlerLever() {
        return Level.ONE;
    }

    @Override
    public Response echo(Request request) {
        return new Response();
    }
}
