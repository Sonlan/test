package song.mode.handlerChainMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2016/10/23.
 * 请求类型
 */
public class Request {
    //请求待处理的类型
    private final Level level;
    //封装的请求数据
    private Map<Object,Object> data = new HashMap<Object, Object>();
    public Request(Level level,Map<Object,Object> data){
        this.level = level;
        this.data = data;
    }
    public Level getRequestLevel(){
        return this.level;
    }
    public Map<Object,Object> getRequestData(){
        return this.data;
    }
}
