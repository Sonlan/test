package song.handlerChainMode;

/**
 * Created by Song on 2016/10/23.
 * 责任链上的具体一环
 */
public class Handler2 extends Handler {
    @Override
    public Level getHandlerLever() {
        return Level.TWO;
    }

    @Override
    public Response echo(Request request) {
        return new Response();
    }
}
