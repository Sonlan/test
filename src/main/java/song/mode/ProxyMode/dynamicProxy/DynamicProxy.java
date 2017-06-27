package song.mode.ProxyMode.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by Song on 2017/6/24.
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public  Object getProxy(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    //
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = method.invoke(target,args);

        return result;
    }

    private void before(){

    }
}
