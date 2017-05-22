package song.mode.handlerChainMode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Song on 2016/10/23.
 * 责任链模式
 */
public class Client {
    public static void main(String [] args){
        //构建责任链
        Handler handler1 = new Handler1();
        Handler handler2 = new Handler2();
        handler1.setNextHandler(handler2);
        //模拟构建请求
        Map<Object,Object> map = new HashMap<Object, Object>();
        map.put("name","Mary");
        Request request = new Request(Level.TWO,map);
        //将请求交给责任链响应，并获得处理结果
        Response response = handler1.handler(request);
        //TO-DO
    }
}
